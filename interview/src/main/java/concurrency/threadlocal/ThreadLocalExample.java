package concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author badrikant.soni
 */
public class ThreadLocalExample {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
    static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread Name : " + Thread.currentThread().getName());
                String formatter = threadLocalExample.formatter();
                System.out.println("Formatted Date : " + formatter);
            }
        });
/*
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread Name : " + Thread.currentThread().getName());
                String formatter = threadLocalExample.formatter();
                System.out.println("Formatted Date : " + formatter);
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread Name : " + Thread.currentThread().getName());
                String formatter = threadLocalExample.formatter();
                System.out.println("Formatted Date : " + formatter);
            }
        });*/

        executorService.shutdown();
    }

    private String formatter() {
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
