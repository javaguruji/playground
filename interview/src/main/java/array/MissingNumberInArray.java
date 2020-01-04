package array;

/**
 * @author badrikant.soni
 */
public class MissingNumberInArray {

    private static int findMissingNumber(int[] arr, int len) {

        int expectedSum = len * (len + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum = actualSum + num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        System.out.println("length : " + arr.length);
        System.out.println(findMissingNumber(arr, 8));
    }
}
