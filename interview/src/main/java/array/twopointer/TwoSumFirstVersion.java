package array.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/two-sum/
 */
public class TwoSumFirstVersion {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15, 2};
        int target = 9;
        final int[] twoSum = findTwoSum(nums, target);
        for (int a : twoSum) {
            System.out.println(a);
        }
    }


    private static int[] findTwoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            // calculate the complement number
            int complement = target - nums[i];
            if (!map.containsKey(complement)) {

                // put number and index in map
                map.put(nums[i], i);
            } else {

                // search in map
                result[0] = map.get(complement);
                result[1] = i;

                System.out.println(complement + " : " + nums[i]);
            }
        }
        return result;
    }
}
