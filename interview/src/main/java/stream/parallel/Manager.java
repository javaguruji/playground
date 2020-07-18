package stream.parallel;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author badrikant.soni
 *
 * link : http://fahdshariff.blogspot.com/search/label/completablefuture
 *
 * ForkJoinPool#commonPool() is a static thread-pool, which is lazily initialized when is actually needed.
 *
 * CommonPool==> it has two concepts in JDK . 1) CompletableFuture 2) Parallel Stream.
 * there is small differene between in two is, CompleteableFuture allows to use custom thread pool instead of using the CommonPool.
 * but Parallel Stream always uses the CommonPool.
 *
 *
 * Usage :
 * CompletableFutures provide more control over the size of the thread pool and should be used if your tasks involve I/O.
 * However, if you're doing CPU-intensive operations, there's no point in having more threads than processors, so go for a parallel stream
 *
 */
public class Manager {

    public static void main(String[] args) {

        // Let's create ten tasks, each with a duration of 1 second:
        List<MyTask> taskList = IntStream.range(0, 10)
                .mapToObj(value -> new MyTask(1))
                .collect(Collectors.toList());

        // How can we calculate the list of tasks efficiently?

        // Approach 1 : Sequentially
        //runSequentially(taskList);

        // Approach 2 : Parallel Stream
        //runParalleStream(taskList);

        // Approach 3 : CompletableFuture
        runCompleteTableFuture(taskList);

        // Approach 4 : CompletableFutureWithExecutor
        //runCompleteTableFutureWithExecutor(taskList);


    }

    private static void runCompleteTableFutureWithExecutor(List<MyTask> taskList) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors : " + availableProcessors);
        long freeMemory = Runtime.getRuntime().freeMemory();
        long mb = 1024L * 1024L;
        System.out.println("Free Memory : " + freeMemory/mb);
        System.out.println("total Memory : " + Runtime.getRuntime().totalMemory()/mb);
        System.out.println("max Memory : " + Runtime.getRuntime().maxMemory()/mb);

        long start = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(Math.max(taskList.size(), 10));
        List<CompletableFuture<Integer>> completableFutureList = taskList.stream()
                .map(myTask -> CompletableFuture.supplyAsync(() -> myTask.calculate(), executor))
                .collect(Collectors.toList());

        List<Integer> results = completableFutureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        long duration = (System.nanoTime() - start)/1000000;
        System.out.printf("processed %d tasks in the %d millis\n", taskList.size(), duration);
        System.out.println(results); // Processed 10 tasks in 1009 millis

        executor.shutdown();
    }

    private static void runCompleteTableFuture(List<MyTask> taskList) {
        long start = System.nanoTime();
        List<CompletableFuture<Integer>> completableFutureList = taskList.stream()
                .map(myTask -> CompletableFuture.supplyAsync(() -> myTask.calculate()))
                .collect(Collectors.toList());

        List<Integer> results = completableFutureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        long duration = (System.nanoTime() - start)/1000000;
        System.out.printf("processed %d tasks in the %d millis\n", taskList.size(), duration);
        System.out.println(results); // processed 10 tasks in the 2007 millis

    }

    private static void runParalleStream(List<MyTask> taskList) {

        long start = System.nanoTime();
        // parallel stream uses the ForkJoinPool.CommonPool-Workers
        List<Integer> results = taskList.parallelStream().map(MyTask::calculate).collect(Collectors.toList());
        long duration = (System.nanoTime() - start)/1000000;
        System.out.printf("processed %d tasks in the %d millis\n", taskList.size(), duration);
        System.out.println(results); // processed 10 tasks in the 2017 millis
    }

    private static void runSequentially(List<MyTask> taskList) {

        long start = System.nanoTime();
        List<Integer> result = taskList.stream().map(MyTask::calculate).collect(Collectors.toList());
        long duration = (System.nanoTime() - start)/1000000;
        System.out.printf("Processed %d tasks in the %d millis\n", taskList.size(), duration);
        System.out.println(result); // Processed 10 tasks in the 10044 millis
    }
}
