package thread.threadlocal.example;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author badrikant.soni
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadLocalPerThread threadLocalPerThread = new ThreadLocalPerThread();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date();
                    String formatDate = threadLocalPerThread.getDate(date);
                    System.out.println(Thread.currentThread().getName() + " : " + formatDate);
                }
            });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                String formatDate = threadLocalPerThread.getDate(date);
                System.out.println(Thread.currentThread().getName() + " : " + formatDate);
                System.out.println(Thread.currentThread().getName() + " : " +"Setting new data object");
                threadLocalPerThread.setDate(date);
                String formatDate1 = threadLocalPerThread.getDate(date);
                System.out.println(Thread.currentThread().getName() + " : " + formatDate1);
            }
        });


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                String formatDate = threadLocalPerThread.getDate(date);
                System.out.println(Thread.currentThread().getName() + " : " + formatDate);
            }
        });

        executorService.shutdown();
    }
}
