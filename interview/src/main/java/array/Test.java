package array;

import java.util.*;

/**
 * @author badrikant.soni
 */
public class Test {

    public static void test(String[] args) {

        int[] A = {3,2,-2, 5, -3};
        System.out.println(greatestNegative(A));
        System.out.println(greatestNegative1(A));



    }

    static void printPairs(int arr[], int n)
    {
        ArrayList<Integer> v = new ArrayList<Integer> ();
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        // For each element of array.
        for (int i = 0; i < n; i++)
        {

            // If element has not encounter early,
            // mark it on cnt array.
            if (cnt.containsKey(Math.abs(arr[i])))
                cnt.put(Math.abs(arr[i]), 1);

                // If seen before, push it in vector
                // (given that elements are distinct)
            else
            {
                v.add(Math.abs(arr[i]));
                cnt.put(Math.abs(arr[i]), 0);
            }
        }

        if (v.size() == 0)
            return;

        Collections.sort(v);
        for (int i = 0; i < v.size(); i++)
            System.out.print("-" + v.get(i) +
                    " " + v.get(i) + " ");
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 4, 8, 9, -4, 1, -1, -8, -9 };
        int n = arr.length;
       // printPairs(arr, n);
       // printPairst(arr, n);
        find(arr);
    }


    public static int greatestNegative(int[] list) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < 0) {
                if (result == 0 || list[i] > result) {
                    result = list[i];
                }
            }
        }
        return result;
    }

    public static int greatestNegative1(int[] A) {
        int negativeNumbers = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && A[i] < negativeNumbers)
                negativeNumbers  = A[i];
        }

        return negativeNumbers;
    }

    public static void printPairst(int arr[], int n)
    {
        Set<Integer> pairs = new HashSet<Integer>();
        boolean pair_exists = false;

        // Store all the positive elements
        // in the unordered_set
        for (int i = 0; i < n; i++)
            if (arr[i] > 0)
                pairs.add(arr[i]);


        int max = 0;

        for (int i = 0; i < n; i++)
        {

            if (arr[i] > max){
                max = arr[i];

            }

        }

        System.out.println(max);

        // Start traversing the array
        for (int i = 0; i < n; i++)
        {
            if (arr[i] < 0){



                // Check if the positive value of current
                // element exists in the set or not

                if (pairs.contains(-arr[i]))
                {
                    // Print that pair



                        System.out.println(arr[i] + ", " + -arr[i]);

                        pair_exists = true;


                }

            }


        }

        if (pair_exists == false)
            System.out.println("No such pair exists");
    }

    static void find(int[] A) {
        Arrays.sort(A);
        Set<Integer> pairs = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++)
                pairs.add(A[i]);

        int end = A.length - 1;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] < 0){
                if(pairs.contains(-A[end])){
                    result = A[end];
                    System.out.println(A[end]);
                    break;
                }
            }
            end--;
        }
    }
}
