package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 https://github.com/bephrem1/backtobackswe/blob/master/Stacks%20%26%20Queues/MaxStack/MaxStack.java
 https://www.youtube.com/watch?v=nGwn8_-6e7w
 Question: Design a stack that includes a max operation, in addition to push and pop. The max method should return the maximum value stored in the stack.
*/

public class MaxInStack {

    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 6, 2};
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(5);
        maxStack.push(3);
        maxStack.push(6);

        System.out.println(maxStack.max());

    }

}

class MaxStack {

    private Deque<Integer> actualElement = new LinkedList<Integer>();
    private Deque<MaxWithCount> cachedMaxWithCount = new LinkedList<>();

    public void push(int item) {

        /*
         * Push the element to our actual elements BUT we are not done. We must see how
         * this element influences our max cache state
         */
        actualElement.push(item);

        /*
         * If the max cache is empty then just add this element, otherwise see how this
         * element contributes to the max cache
         *
         * 1.) If it is the same as the max element, add 1 to the occurrences of the top
         * item on the cache
         *
         * 2.) If it is greater than the max element then we have a new maximum item,
         * create a cache entry for it
         *
         * 3.) If it is less than the item at the top of the cache then NOTHING HAPPENS,
         * this item does not get an entry and it is ignored in terms of contributing to
         * the max stack cache state
         */

        /*
        Integer.compare(x, y) ==>
        if(x < y) return -1
        if(x == y) return 0
        if(x > y) return -1

        cachedMaxWithCount.peekFirst() ==> always fetch the top element object(max, count)
        cachedMaxWithCount.addFirst() ==> always add in front of deque.

         */
        if (!cachedMaxWithCount.isEmpty()) {
            // if elements are repeated(same elements are getting inserted more than one)
            if (Integer.compare(item, cachedMaxWithCount.peekFirst().max) == 0) {
                cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count + 1;
            } else if (Integer.compare(item, cachedMaxWithCount.peekFirst().max) > 0) {
                cachedMaxWithCount.addFirst(new MaxWithCount(item, 1));
            }
        } else {
            cachedMaxWithCount.addFirst(new MaxWithCount(item, 1));
        }

    }

    /*
     * To check if the MaxStack is empty we just make an underlying call to the
     * stack of the actualElements
     */
    public boolean isEmpty() {
        return actualElement.isEmpty();
    }

    public int pop(){

        if(isEmpty()){
            throw new IllegalStateException("max(): empty stack");
        }

        Integer popElement = actualElement.removeFirst();

        /*
         * If the element that we popped was a max element we need to take action to
         * update our max cache stack.
         */
        if(popElement.equals(cachedMaxWithCount.peekFirst().max)){
            /*
             * Reduce the count of occurrences of the element at the top of the max cache
             * stack since we just popped a max element
             */
            cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count - 1;

            /*
             * If there are no more of this max element then remove this entry from the max
             * cache stack
             */
            if(cachedMaxWithCount.peekFirst().count == 0){
                cachedMaxWithCount.removeFirst();
            }
        }

        return popElement;

    }


    public int max() {
        if (actualElement.isEmpty()) {
            throw new IllegalStateException();
        }
        return cachedMaxWithCount.peekFirst().max;
    }

}

class MaxWithCount {
    int max;
    int count;

    public MaxWithCount(int max, int count) {
        this.max = max;
        this.count = count;
    }
}
