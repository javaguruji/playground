package array;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testArrayWithMissingNumber(){
        int[] given = {1, 2, 4, 6, 3, 7, 8};
        int actual = findMissingNumber(given, 8);
        int expected = 5;
        assertEquals(actual, expected);

    }

    @Test
    public void testMissingNumberWithSortedArray(){
        int[] given = {1, 2, 3, 4, 6, 7, 8};
        int actual = findMissingNumber(given, 8);
        int expected = 5;
        assertEquals(actual, expected);

    }

    @Test
    public void testMissingNumberWithDuplicateElementsInArray(){
        int[] given = {1, 3, 3, 4, 6, 7, 8};
        int actual = findMissingNumber(given, 8);
        int expected = 5;
        assertNotEquals(actual, expected);

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        System.out.println("length : " + arr.length);
        System.out.println(findMissingNumber(arr, 8));
    }
}
