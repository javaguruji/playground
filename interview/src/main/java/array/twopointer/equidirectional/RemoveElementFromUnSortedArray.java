package array.twopointer.equidirectional;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class RemoveElementFromUnSortedArray {

    public static void main(String[] args) {
        int[] arr = {10,2,5,10,9,1,1,4,3,7};
        Arrays.sort(arr);
        for(int a : arr){
            System.out.print(a);
        }
        System.out.println();
        final int length = removeDuplcateElement(arr);
        for(int i = 0; i < length ; i++){
            System.out.print(arr[i]);
        }

        System.out.println();
        findMissingNumbers(arr, length);

    }

    private static void findMissingNumbers(int[] arr, int n) {

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n ; i++){
            set.add(arr[i]);
        }
        System.out.println(set);
        int temp = 1;
        for(int i=0; i < set.size() ; i++){
            if(!set.contains(temp)){
                System.out.print(temp);
                temp++;
            }else{
                temp++;
            }
        }

    }

    private static int removeDuplcateElement(int[] arr) {

        int temp = 0;
        for(int element = 1; element < arr.length ; element ++){
            if(arr[element] != arr[temp]){
                temp++;
                arr[temp] = arr[element];
            }
        }
        return temp + 1;
    }
}
