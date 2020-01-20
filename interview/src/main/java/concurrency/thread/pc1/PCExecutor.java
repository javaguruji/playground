package concurrency.thread.pc1;

/**
 * @author badrikant.soni
 *
 * Problem
 *
 * To make sure that the producer won’t try to add data into the buffer if it’s full
 * and that the consumer won’t try to remove data from an empty buffer.
 *
 * Solution
 *
 * The producer is to either go to sleep or discard data if the buffer is full.
 * The next time the consumer removes an item from the buffer, it notifies the producer,
 * who starts to fill the buffer again. In the same way, the consumer can go to sleep if it finds the buffer to be empty.
 * The next time the producer puts data into the buffer, it wakes up the sleeping consumer.
 * An inadequate solution could result in a deadlock where both processes are waiting to be awakened.
 */
public class PCExecutor {

    public static void main(String[] args) throws InterruptedException {

        PC1 pc1 = new PC1(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc1.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc1.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();

    }
}
