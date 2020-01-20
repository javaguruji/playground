package concurrency.thread.pc2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author badrikant.soni
 * Single Responsibility -  Let this class be responsible for only adding and removing the items.
 * the PC2 is responsible for storing and removing the elements in a thread-safe manner.
 *
 * we’ve created a buffer that, when storing an element,
 * waits for a slot to become available in case there is no more space, and, on pooling,
 * in case that the buffer is empty, it waits for an element to become available,
 * making the storing and removing operations thread-safe.
 */
public class PC2 {

    private Queue<Integer> queue;
    private int size;

    PC2(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }

    void produce(int value) throws InterruptedException {

        synchronized (this){
            if (queue.size() == size){
                wait();
            }
            queue.add(value);
            notify();
        }

    }

    int consume() throws InterruptedException {
        synchronized (this){
            if (queue.isEmpty()){
                wait();
            }
            Integer value = queue.poll();
            notify();
            return value;
        }
    }
}
