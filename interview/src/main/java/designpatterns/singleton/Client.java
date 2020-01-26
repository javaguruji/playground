package designpatterns.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author badrikant.soni
 */
public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Object> submit1 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                SingletonExample instance = SingletonExample.getInstance();
                Thread.sleep(1000);
                return instance;
            }
        });

        Future<Object> submit2 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                SingletonExample instance = SingletonExample.getInstance();
                Thread.sleep(1000);
                return instance;
            }
        });

        if(submit1.get().equals(submit2.get())){
            System.out.println(true);
        }
        executorService.shutdown();

        SingletonExample instance1 = SingletonExample.getInstance();
        SingletonExample instance2 = SingletonExample.getInstance();

        if(instance1.equals(instance2)){
            System.out.println(true);
        }
    }
}
