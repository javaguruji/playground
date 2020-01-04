package array;

/**
 * @author badrikant.soni
 */
public class ArrayTest {
    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{0,1,2,3,4,5,6,7,8};
        print(intArray);
    }

    private static void print(Integer[] intArray) {
        int len = intArray.length; // total elements in the array
        System.out.println(len);

        for(int i = 0; i <= intArray.length-1 ; i++){
            System.out.print(intArray[i] + ",");
        }
    }
}
