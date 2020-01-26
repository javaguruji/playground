package concurrency.thread.questions;

/**
 * @author badrikant.soni
 */
public class ThreadExample1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1");

            }
        });


        t1.start();
        t1.join();
    }
}
