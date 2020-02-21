package array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author badrikant.soni
 * https://www.geeksforgeeks.org/print-all-pairs-with-given-sum/
 * Print all pairs with given sum
 * Given an array of integers, and a number ‘sum’, print all pairs in the array whose sum is equal to ‘sum’.
 *
 * Examples :
 * Input  :  arr[] = {1, 5, 7, -1, 5},
 *           sum = 6
 * Output : (1, 5) (7, -1) (1, 5)
 *
 * Input  :  arr[] = {2, 5, 17, -1},
 *           sum = 7
 * Output :  (2, 5)
 */
public class FindPairsForGivenSum {

    public static void main(String[] args) {

        int[] arr = {1,9,1,7,8};
        int target = 10;
        Arrays.sort(arr);
        findPairs(arr, target);
        findPairsUsingMap(arr, target);
    }

    private static void findPairs(int[] arr, int target){

        int start = 0;
        int end = arr.length -1 ;
        int sum = 0;
        int[] result = new int[2];
        while(start < end){
            sum = arr[start] + arr[end];
            if(sum == target){
                System.out.println(arr[start] + " : " + arr[end]);
            }
            if(sum > target){
                end --;
            }else{
                start++;
            }
        }
    }

    private static void findPairsUsingMap(int[] arr, int target){
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < arr.length ; i++){
            int rem = target - arr[i];
            if(map.containsKey(rem)){
                System.out.println( arr[i] + " : " + rem);
            }
            map.put(arr[i], 1);
        }
        System.out.println(map);
    }
}
