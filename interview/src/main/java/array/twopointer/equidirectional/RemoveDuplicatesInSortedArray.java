package array.twopointer.equidirectional;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * solve another way : https://www.javatpoint.com/java-program-to-remove-duplicate-element-in-an-array
 */
// two pointer with copy array to another array
public class RemoveDuplicatesInSortedArray {

    private static int removeDuplicate(int[] nums) {

        int temp = 0; // take separate index
        for(int second = 1 ; second < nums.length ; second++){  // fast pointer

            // if they are not equal, increase the temp index and copy the element to nums[temp]
            if(nums[second] != nums[temp]){
                temp++;
                nums[temp] = nums[second];
            }
        }
        return temp + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4};
        System.out.println(arr.length);
        final int length = removeDuplicate(arr);

        for(int i = 0; i < length ; i++){
            System.out.print(arr[i]);
        }
    }
}
