package array;

public class FindTwoElementsWithMaximumDifference {

    public static void main(String[] args) {

        int[] arr = {30, 12, 15, 22, 25, 7, 18};
        int[] twoElement = findTwoElement(arr);
        for (int a : twoElement) {
            System.out.println(a);
        }

        System.out.println(findTwoElementTricky(arr));
    }

    // Time Complexity O(n2) and Space Complexity O(n).
    private static int[] findTwoElement(int[] arr) {

        int maxDiff = arr[1] - arr[0];
        int result[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > maxDiff) {
                    maxDiff = arr[j] - arr[i];
                    result[0] = arr[i];
                    result[1] = arr[j];
                }
            }
        }
        return result;
    }

    /*
      maintain two variables
      1. maxDifference
      2. minElement

      Initially we will assume that first element of array which arr[0] is minElement.
      Similarly assume difference between second and first element of array is maxDifference.

      Inside loop.
      we will check & update both variables. -
      1. update maxDifference if difference between currentElement and minElement is greater than maxDifference.
      2. update minElement if currentElement less than minElement.
      3. at the end, maxDifference will be our answer.
     */
    // Time Complexity O(n) and Space Complexity O(1).
    private static int findTwoElementTricky(int[] arr){

        int minElement = arr[0];
        int maxDifference = arr[1] - arr[0];
        for(int i = 1; i < arr.length ; i++){
            if(arr[i] - minElement > maxDifference){
                maxDifference = arr[i] - minElement;
            }

            if(arr[i] < minElement){
                minElement = arr[i];
            }
        }
        return maxDifference;
    }
}
