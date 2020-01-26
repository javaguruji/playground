package designpatterns.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author badrikant.soni
 */
public class ClientThreadSafeTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Object> submit1 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                SingletonWithThreadSafe instance = SingletonWithThreadSafe.getInstance();
                Thread.sleep(1000);
                System.out.println(instance);
                return instance;
            }
        });

        Future<Object> submit2 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                SingletonWithThreadSafe instance = SingletonWithThreadSafe.getInstance();
                Thread.sleep(1000);
                System.out.println(instance);
                return instance;
            }
        });


        Future<Object> submit3 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                SingletonWithThreadSafe instance = SingletonWithThreadSafe.getInstance();
                Thread.sleep(1000);
                System.out.println(instance);
                return instance;
            }
        });


        Future<Object> submit4 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                SingletonWithThreadSafe instance = SingletonWithThreadSafe.getInstance();
                Thread.sleep(1000);
                System.out.println(instance);
                return instance;
            }
        });


        Future<Object> submit5 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                SingletonWithThreadSafe instance = SingletonWithThreadSafe.getInstance();
                Thread.sleep(1000);
                System.out.println(instance);
                return instance;
            }
        });

        if (submit1.get().equals(submit2.get())) {
            System.out.println(true);
        }
        executorService.shutdown();

    }
}
