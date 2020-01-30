package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author badrikant.soni
 */
public class EvenAndOddPrint {

    int number = 1;

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(2);



        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        executorService.shutdown();

    }

}
