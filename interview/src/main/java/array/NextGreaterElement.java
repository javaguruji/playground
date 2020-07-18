package array;

import java.util.Stack;

/**
 * @author badrikant.soni
 * https://www.geeksforgeeks.org/next-greater-element/
 *
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 *
 * int[] arr = {4, 5, 2, 25};
 * 
 * Element       NGE
 *    4      -->   5
 *    5      -->   25
 *    2      -->   25
 *    25     -->   -1
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 25};
        //nextGreaterElement(arr);
        nextGreaterElementUsingStack(arr);

    }

    // Time complexity O(n2)
    private static void nextGreaterElement(int[] arr) {
        int next;
        // outer loop picks all element one by one
        for (int i = 0; i < arr.length; i++) {

            // inner loop looks for the first greater element for the element picked by the outer loop.
            next = -1;
            for (int j = i + 1; j < arr.length; j++) {

                // if greater element is found then that element is printed as next, otherwise -1 is printed.
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + "--->" + next);
        }
    }

    // O(n) complexity
    private static void nextGreaterElementUsingStack(int[] arr){

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length ; i++){
            while(!stack.isEmpty()){
                Integer peek = stack.pop();
                if(peek < arr[i]){
                    System.out.println(peek + "--->" + arr[i]);
                }else{
                    stack.push(peek);
                    break;
                }
            }
            stack.push(arr[i]);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop()+"--->" + "-1");
        }
    }
}
