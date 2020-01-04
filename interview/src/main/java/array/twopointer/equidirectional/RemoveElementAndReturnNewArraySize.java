package array.twopointer.equidirectional;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/remove-element/
 */
public class RemoveElementAndReturnNewArraySize {
    /*
        Given nums = [3,2,2,3], val = 3,
        Your function should return length = 2, with the first two elements of nums being 2.
     */

    // When nums[j] equals to the given value, skip this element by incrementing j.
    // As long as nums[j] != val, we copy nums[j] to nums[i] and increment both indexes at the same time.
    // Repeat the process until j reaches the end of the array and the new length is i.
    private static int removeElement(int[] arr, int val) {
        int temp = 0;
        for (int start = 0; start < arr.length; start++) {
            if (arr[start] != val) {
                // copy arr[start] to new arr[temp]
                arr[temp] = arr[start];
                temp++;
            }
        }
        return temp;
    }


    private static int reduceArraySize(int[] arr, int val) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            if (arr[start] == val) {
                arr[start] = arr[end - 1];
                // reduce array size
                end--;
            } else {
                start++;
            }
        }
        return end;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
        System.out.println("current lenght : " + arr.length);
        System.out.println("length after remove : " + removeElement(arr, 2));
    }
}
