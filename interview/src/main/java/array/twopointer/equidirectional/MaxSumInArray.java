package array.twopointer.equidirectional;

/**
 * @author badrikant.soni
 */
public class MaxSumInArray {

    public static void main(String[] args) {

        int[] intArray = new int[]{1, 2, -1, 4, 3, 2, 1};  // length = 7
        int k = 4;
        System.out.println(getMaxSumSubArrayOfSizeKM1(intArray, k));
        System.out.println(getMaxSumSubArray(intArray, k));
    }

    // brute force, time complexity O(m*k)
    private static int getMaxSumSubArrayOfSizeKM1(int[] A, int k) {
        int maxSum = 0;
        ;
        for (int i = 0; i <= A.length - k; i++) {

            int windowSum = 0;

            for (int j = i; j < i + k; j++) {
                windowSum += A[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    // two pointer with sliding window technique
    private static int getMaxSumSubArray(int[] A, int k) {
        int windowSum = 0;
        int maxSum = 0;
        // get the sum of k elements
        for (int i = 0; i < k; i++) {
            windowSum = windowSum + A[i];
        }

        //
        for (int end = k; end < A.length; end++) {
            windowSum = windowSum + A[end] - A[end - k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }
}
