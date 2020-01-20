package concurrency.thread.pc1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author badrikant.soni
 */
class PC1 {

    private Queue<Integer> queue;
    private int size;

    PC1(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }

    void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                if (queue.size() == size) {
                    wait();
                }

                System.out.println("producer procuded : " + value);
                queue.add(++value);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    void consumer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (queue.isEmpty()) {
                    wait();
                }
                Integer poll = queue.poll();
                System.out.println("Consumer consumed : " + poll);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
