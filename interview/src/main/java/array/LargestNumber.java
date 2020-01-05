package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/largest-number/solution/
 *
 * Algo :
 * 1. Convert input to string array
 * 2. Sorting the string array into descending order using custom comparator class.
 * 3. After sorting if largest number is 0, then return 0.
 * 4. Lastly build largest number by iterating sorted string array using string builder class.
 *
 * time complexsity : 0(n)
 * space complexity : 0(n)
 */
public class LargestNumber {

    public static void main(String[] args) {

        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    static class LargestNumberComparator implements Comparator<String> {

        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    private static String largestNumber(int[] nums) {

        // 1. convert integer array to string array
        String str[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        // 2. sort the string array using custom comparator(descending order)
        Arrays.sort(str, new LargestNumberComparator());


        // 3. after sorting if largest number is zero , then return zero
        if (str[0].equals("0")) {
            return "0";
        }

        // 4. build the largest number from sorted string array
        StringBuilder largestNumber = new StringBuilder();
        for (String s : str) {
            largestNumber.append(s);
        }

        return largestNumber.toString();
    }
}


