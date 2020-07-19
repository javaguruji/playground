package practice.threadtest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author badrikant.soni
 */
public class PC {

    Queue<Integer> queue;
    int size;

    public PC(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public void produce(int value) throws InterruptedException {
        synchronized (this) {
            if (queue.size() == size) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(value);
            notify();
        }

    }

    public int consume() throws InterruptedException {
        synchronized (this) {
            if (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer value = queue.poll();
            notify();
            return value;
        }
    }

}
