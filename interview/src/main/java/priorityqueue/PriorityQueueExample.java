package priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author badrikant.soni
 * refer : https://howtodoinjava.com/java/collections/java-priorityqueue/
 * 1. The objects of the priority queue are ordered by default in natural order(Ascending)
 * 2. It doesn't allow null objects.
 * 3. objects of priority queue must be comparable.
 * 4. priority queue is not thread safe.
 * 5. O(log(n)) time for add() and poll().
 * 6. When poll the queue, it will return the head object from the queue.
 * 7. Camparator can be used for custom ordering of objects in the queue.
 */
public class PriorityQueueExample {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{5, 3, 2, 8, 2, 1};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Arrays.asList(arr));
        System.out.println("Number of elements in priority queue : " + priorityQueue.size());
        System.out.print("[");
        while (true) {
            Integer poll = priorityQueue.poll();
            if (poll == null) {
                break;
            }
            System.out.print(poll + ",");
        }
        System.out.print("]");
    }
}
