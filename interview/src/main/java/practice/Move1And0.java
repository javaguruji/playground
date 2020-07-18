package practice;

/**
 * @author badrikant.soni
 */
public class Move1And0 {

    public static void main(String[] args) {

        int[] array = {0,1,1,0,1,0,1,1,0};

        // o/p -> {0,0,0,0,1,1,1,1,1}

        // condition -> without using any extra space

        int[] move = move(array);
        for(int a : move){
            System.out.print(a + ",");
        }

        System.out.println();

        int[] inPlaceMove = inPlaceMove(array);
        for(int a : inPlaceMove){
            System.out.print(a + ",");
        }
    }

    // time complexity  : O(n)
    // Space Complexity : O(1)
    private static int[] inPlaceMove(int[] array) {

        int start = 0;
        int end = array.length-1;

        for(int i = start; i < array.length-1 ; i++){

            // copy non zero into the end of the array
            if(array[i] != 0){
                array[end] = array[i];
                end--;
            }
        }

        // put zero in the remaining places.
        for(int j = end; j > start; j--){
            array[j] = 0;
        }
        return array;

    }


    // time complexity - O(n)
    // space complexity - O(n)
    private static int[] move(int[] array) {

        // count all zero and ones
        int zeroCounter = 0;
        int oneCounter = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                zeroCounter++;
            }
            if(array[i] == 1){
                oneCounter++;
            }
        }
        int temp = 0;
        int[] newArray = new int[zeroCounter + oneCounter];
        for(int i = 0; i < zeroCounter; i++){
            newArray[i] = 0;
            temp++;
        }
        for(int j = temp; j<newArray.length; j++){
            newArray[j] = 1;
        }
        return newArray;
    }

}
