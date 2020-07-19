package practice.threadtest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author badrikant.soni
 */
public class PCWithBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for(int value = 0; value < 20 ; value ++) {
                    try {
                        queue.put(value);
                        System.out.println("[producer] Put : " + value);
                        System.out.println("[producer] Queue remaining capacity : " + queue.remainingCapacity());
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Integer value = queue.take();
                        System.out.println("[consumer] Take : " + value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.shutdown();
    }
}
