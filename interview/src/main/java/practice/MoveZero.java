package practice;

/**
 * @author badrikant.soni
 */
public class MoveZero {

    public static void main(String[] args) {

        int[] arr = {0,1,0, 3, 12};
        int[] moves = move(arr);
        for(int move : moves){
            System.out.print(move + ",");
        }
    }
    private static int[] move(int[] arr) {

        // iterate through the array.
        // if you find non zero element, then move them in temp array with same new index
        // if you find zero element, increase the counter by 1
        // at last add the number zero in last.
        int count = 0;
        int temp = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != 0){
                arr[temp] = arr[i];
                temp++;
            }else {
                count++;
            }
        }
        for(int j = 0; j < count; j++){
            arr[temp] = 0;
            temp++;
        }
        return arr;
    }
}
