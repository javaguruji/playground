package array;

/**
 * @author badrikant.soni
 * https://www.youtube.com/watch?v=1_Lz_EvA_hs
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7)
 */
public class MaximumSumOfNonAdjacentElements {

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 5};
        System.out.println(maxSum(arr));

    }

    private static int maxSum(int[] arr) {

        int include = arr[0];  // it tells that maximum sum obtains so far including the previous element.
        int exclude = 0; // it tells that maximum sum obtains so far excluding the previous element.
        int old_include = 0;

        for (int i = 1; i < arr.length; i++) {

            /* current max including i */
            old_include = include;
            include = arr[i] + exclude;

            /* current max excluding i */
            exclude = Math.max(old_include, exclude);

        }
        return Math.max(include, exclude);
    }
}
