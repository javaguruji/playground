package concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author badrikant.soni
 */
public class ExecutorServiceTest {

    public static void main(String[] args) {

        System.out.println("Running Main Thread");
        //newSingleThreadExecutor();
        newFixedThreadPool();
        //newScheduledThreadPool();
        //newCachedThreadPool();
    }

    private static void newSingleThreadExecutor() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("newSingleThreadExecutor thread");
            }
        });
        executorService.shutdown();
    }

    // create pool of new threads and execute the given task.
    private static void newFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            final int name = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("newFixedThreadPool thread" + ":" + name);
                }
            });
        }
        executorService.shutdown();
    }

    // if any task needs to be scheduled at any time or an fixed rate
    private static void newScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            //scheduledExecutorService.schedule(new Task(i), 5, TimeUnit.SECONDS);
            //scheduledExecutorService.scheduleAtFixedRate(new Task(i), 10, 5, TimeUnit.SECONDS);
            scheduledExecutorService.scheduleWithFixedDelay(new Task(i), 5, 3, TimeUnit.SECONDS);
        }
    }

    // When needed, it creates new thread and it any thread is idle for 60 sec, it will terminate automatically
    private static void newCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Task());
        executorService.shutdown();
    }
}

class Task implements Runnable {
    private int name;

    Task(int i) {
        this.name = i;
    }

    Task() {

    }

    @Override
    public void run() {
        System.out.println("I am a task class" + ":" + name);
    }
}
