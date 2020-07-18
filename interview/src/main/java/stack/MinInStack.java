package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author badrikant.soni
 */
public class MinInStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(1);
        minStack.push(2);

        System.out.println(minStack.min());

    }
}

class MinStack {

    private Deque<Integer> actualElements = new LinkedList<Integer>();
    private Deque<MinWithCount> cachedMinWithCounts = new LinkedList<>();

    private boolean isEmpty() {
        return actualElements.isEmpty();
    }

    public void push(int item) {

        actualElements.addFirst(item);
        if (!cachedMinWithCounts.isEmpty()) {

            if (Integer.compare(item, cachedMinWithCounts.peekFirst().min) == 0) {
                cachedMinWithCounts.peekFirst().count = cachedMinWithCounts.peekFirst().count + 1;
            } else if (Integer.compare(item, cachedMinWithCounts.peekFirst().min) < 0) {
                cachedMinWithCounts.addFirst(new MinWithCount(item, 1));
            }
        } else {
            cachedMinWithCounts.addFirst(new MinWithCount(item, 1));
        }
    }

    public int min() {

        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return cachedMinWithCounts.peekFirst().min;
    }

}


class MinWithCount {
    int min;
    int count;

    MinWithCount(int min, int count) {
        this.min = min;
        this.count = count;
    }
}


