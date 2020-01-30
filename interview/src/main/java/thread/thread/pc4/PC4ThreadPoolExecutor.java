package thread.thread.pc4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author badrikant.soni
 * ThreadPool : https://allegro.tech/2015/05/thread-pools.html
 *
 *
 * Good software design techniques suggest that threads should not be created and destroyed manually.
 * Thread creation and destruction are expensive processes which consume both CPU and memory,
 * as they require JVM and OS activity. Default Java thread stack size is 1 MB for 64-bit JVMs.
 * That is why creating a new thread for each request when requests are frequent and lightweight is a waste of resources.
 *
 * Thread pools can handle thread lifecycle automatically according to the strategy selected on thread pool creation.
 * An important feature of a thread pool is that it allows applications to degrade gracefully.
 *
 * It holds a limited number of idle threads and reuses them when it needs to solve tasks.
 * This way, we don’t have to create a new thread every time for a new request, and therefore,
 * we can avoid reaching a thread starvation.
 *
 * For running some tasks concurrently, you have to put them in the task queue. Then, when a thread is available,
 * it will receive a task and run it. The more available threads, the more tasks that are executed in parallel.
 */
public class PC4ThreadPoolExecutor {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            int value = 0;
            while (true) {
                try {
                    blockingQueue.put(value);
                    System.out.println("produced : " + value);
                    value++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(() -> {

            while (true) {
                try {
                    Integer value = blockingQueue.take();
                    System.out.println("consumed : " + value);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        executorService.shutdown();
    }
}
