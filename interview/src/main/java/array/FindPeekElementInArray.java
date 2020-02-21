package array;

/**
 * @author badrikant.soni
 */
public class FindPeekElementInArray {

    public static void main(String[] args) {

        int[] arr = {5, 7, 3, 9, 10, 12};

        peekElement(arr);

    }

    private static void peekElement(int[] arr) {

        int firstElement = arr[0];
        int lastElement = arr[arr.length -1];
        for(int i = 0; i < arr.length ; i++){

            if(firstElement > arr[i+1]){
                System.out.println(firstElement);
            }

            if(lastElement > arr[arr.length-2]){
                System.out.println(lastElement);
            }

        }

    }
}
