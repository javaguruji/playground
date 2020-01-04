package array.twopointer.oppositedirectional;

import java.util.Arrays;

/**
 * @author badrikant.soni
 * // two pointer technique
 */

public class TwoSum {

    private static int[] findTwoSum(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int[] result = new int[2];

        while (start < end) {

            if (target == arr[start] + arr[end]) {
                result[0] = start;
                result[1] = end;
                break;
            } else if (target > arr[start] + arr[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoSum(new int[]{-3, 2, 3, 3, 6, 8, 15}, 6)));
    }
}
