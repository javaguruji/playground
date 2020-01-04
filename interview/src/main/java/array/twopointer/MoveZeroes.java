package array.twopointer;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        int first = 0;
        int second = 0;
        for (int i = first; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[second] = nums[i];
                second++;
            }
        }
        for (int i = second; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int a : nums) {
            System.out.print(a);
        }
    }
}
