package concurrency.create;

/**
 * @author badrikant.soni
 */
public class ThreadTest {

    public static void main(String[] args) {

        System.out.println("I am main thread");

        RunnableTest runnableTest = new RunnableTest();
        Thread newThread = new Thread(runnableTest);
        newThread.start();

        ThreadExtend threadExtend = new ThreadExtend();
        threadExtend.start();
    }
}

class RunnableTest implements Runnable {
    public void run() {
        System.out.println("I am runnable test thread");
    }
}

class ThreadExtend extends Thread {
    public void run() {
        System.out.println("I am thread extend thread");
    }
}
