package array;

import java.util.Arrays;

/**
 * @author badrikant.soni
 * Time Complexity : o(nlong)
 * Space Complexity : o(1)
 */
public class KthSmallestAndLargestElement {

    public static void main(String[] args) {

        Integer[] intArray = new Integer[]{3, 2, 1, 5, 6, 4};
        System.out.println(kthSmallest(intArray, 2));
        System.out.println(kthLargest(intArray, 2));

    }

    private static int kthSmallest(Integer[] intArray, int k) {

        Arrays.sort(intArray);// 3, 5, 7, 12, 19 // O(N log N)
        return intArray[k - 1];
    }

    private static int kthLargest(Integer[] intArray, int k) {

        Arrays.sort(intArray);
        return intArray[intArray.length - k];
    }
}
