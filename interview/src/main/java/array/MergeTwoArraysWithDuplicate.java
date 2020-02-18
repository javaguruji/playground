package array;

/**
 * @author badrikant.soni
 */
public class MergeTwoArraysWithDuplicate {

    public static void main(String[] args) {

        int[] arr1 = {2,5,7,2,4};
        int[] arr2 = {1,3,4,5,4};

        mergeArraysWithExtraSpace(arr1, arr2);
    }

    private static void mergeArraysWithExtraSpace(int[] arr1, int[] arr2) {

        int len1 = arr1.length;
        int len2 = arr2.length;
        int count = 0;
        int[] arr3 = new int[len1+len2];

        for(int i = 0; i < len1 ; i++){
            arr3[i] = arr1[i];
            count++;
        }

        for(int j = 0; j < len2 ; j++){
            arr3[count] = arr2[j];
            count++;
        }

        for(int a : arr3){
            System.out.print(a + ",");
        }
    }
}
