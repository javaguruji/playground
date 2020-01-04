package array.twopointer.equidirectional;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
// two pointer with copy array to another array
public class RemoveDuplicatesInSortedArray {

    private static int removeDuplicate(int[] nums) {

        int first = 0; // slow pointer
        for(int second = 1 ; second < nums.length ; second++){  // fast pointer
            if(nums[second] != nums[first]){
                first++;
                nums[first] = nums[second];
            }
        }
        return first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(arr.length);
        System.out.println(removeDuplicate(arr));
    }
}
