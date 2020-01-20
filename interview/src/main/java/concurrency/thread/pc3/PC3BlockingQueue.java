package concurrency.thread.pc3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author badrikant.soni
 */
public class PC3BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int value = 0;
                while (true) {
                    try {
                        blockingQueue.put(value);
                        System.out.println("Produced " + value);
                        value++;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Integer value = null;
                    try {
                        value = blockingQueue.take();
                        System.out.println("Consumed : " + value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
