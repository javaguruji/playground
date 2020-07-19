package thread.threadlocal.example;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author badrikant.soni
 */
public class ThreadLocalPerThread {

    // SimpleDateFormat is not thread-safe, Thread local helps to assign one(local copy) to each thread
    private static final ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        }
    };

    public String getDate(Date date) {
        return simpleDateFormatThreadLocal.get().format(date);
    }

    public void setDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        simpleDateFormat.format(date);
        simpleDateFormatThreadLocal.set(simpleDateFormat);
    }
}
