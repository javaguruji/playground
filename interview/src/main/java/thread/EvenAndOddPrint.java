package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author badrikant.soni
 */
public class EvenAndOddPrint {

    private boolean odd;
    private int count = 1;
    private int MAX = 20;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        EvenAndOddPrint evenAndOddPrint = new EvenAndOddPrint();
        evenAndOddPrint.odd = true;

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                evenAndOddPrint.printEven();
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                evenAndOddPrint.printOdd();
            }
        });

        executorService.shutdown();

    }

    private void printOdd() {

        synchronized (this) {
            while (count < MAX) {
                if (!odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Thread :" + count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                count++;
                odd = false;
                notify();
            }
        }
    }

    private void printEven() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        synchronized (this) {
            while (count < MAX) {
                if (odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even thread :" + count);
                count++;
                odd = true;
                notify();
            }
        }
    }
}
