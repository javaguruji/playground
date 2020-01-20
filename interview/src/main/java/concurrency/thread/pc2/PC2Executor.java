package concurrency.thread.pc2;

/**
 * @author badrikant.soni
 */
public class PC2Executor {

    public static void main(String[] args) throws InterruptedException {

        PC2 pc2 = new PC2(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int value = 0;
                while (true) {
                    try {
                        pc2.produce(value);
                        System.out.println("produced : " + value);
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
                    try {
                        int consume = pc2.consume();
                        System.out.println("consumed : " + consume);
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
