package array;

/**
 * @author badrikant.soni
 */
public class MinAndMaxValueFinding {

    public static void main(String[] args) throws Exception {

        int[] values = {5, 1, 2};
        System.out.println(findMinUsingBruteForce(values));
        System.out.println(findMaxUsingFruteForce(values));
        System.out.println(find2ndMaxUsingFruteForce(values));
        System.out.println(find2ndElement(values));

    }

    private static int findMinUsingBruteForce(int[] values) {

        int min = values[0];
        for (int i = 0; i < values.length - 1; i++) {
            // if there is any value which less than my min value, then update the min with new minimum value.
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    private static int findMaxUsingFruteForce(int[] values) {

        int max = 0;
        for (int i = 0; i < values.length - 1; i++) {
            // if there is any value in array is greater than my max value, then update the max with new maximum value.
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }


    // A Better Solution is to traverse the array twice. In the first traversal find the maximum element.
    // In the second traversal find the greatest element less than the element obtained in first traversal.
    // The time complexity of this solution is O(n).
    private static int find2ndElement(int[] values) {

        int max = 0;
        int second = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (values[i] < max) {
                second = values[i];
            }
        }

        return second;
    }

    // A more Efficient Solution can be to find the second largest element in a single traversal.
    private static int find2ndMaxUsingFruteForce(int[] values) {

        int firstMax = 0;
        int secondMax = 0;
        for (int i = 0; i < values.length; i++) {
            // if there is any value in array is greater than my max value, then update the max with new maximum value.
            if (values[i] > firstMax) {
                secondMax = firstMax;
                firstMax = values[i];


            } else if (values[i] > secondMax && values[i] != firstMax) {
                secondMax = values[i];
            }
        }
        return secondMax;
    }
}
