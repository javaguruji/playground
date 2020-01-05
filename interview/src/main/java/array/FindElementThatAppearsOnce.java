package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author badrikant.soni
 * problem : https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
 * problem : https://leetcode.com/problems/single-number/
 * <p>
 * Approach 1 : Brute Force
 * Check every element if it appears once or not. Once an element with single occurance is found, return it.
 * Time Complexity : O(n2)
 * <p>
 * Approach 2 : Hashing technique
 * Traverse all elements and put them in a hashtable. Element is used as key and count of occurance is used as value in hashtable.
 * Time Complexity : O(n)
 * Space Complexity : require extra space
 * <p>
 * Approach 3: XOR Bitwise Operator
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * <p>
 * Approach 4: 2 * ( Sum of unique elmements ) - ( Sum of all elements )
 */
public class FindElementThatAppearsOnce {

    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 3, 5, 4, 5};
        System.out.println(findElement(nums));

        int[] nums1 = {2, 3, 4, 3, 5, 4, 5, 3, 4, 5};
        System.out.println(findElement1(nums1));

    }

    // using XOR bitwise operator
    // 1. XOR of a number with itself is 0. for example : 2 ^ 2 = 0
    // 2. XOR of a number with 0 is number itself. for example : 2 ^ 0 = 2
    private static int findElement(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i]; // XOR bitwise operator
        }
        return result;
    }


    // https://leetcode.com/problems/single-number-ii/
    private static int findElement1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        final Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
