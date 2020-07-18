package array.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author badrikant.soni
 */
public class FindMostConsecutive1s {

    public static void main(String[] args) {

        int number = 245;
        System.out.println(decimalToBinary(number));
        System.out.println(mostConsecutive1s(number));

    }

    private static int mostConsecutive1s(int number){

        int count = 0;
        while(number > 0){
            number = number & (number << 1); // left shift operation
            System.out.println(decimalToBinary(number));
            count++;
        }
        return count;
    }

    private static List<Integer> decimalToBinary(int number){
        ArrayList<Integer> binaryList = new ArrayList<>();
        while (number > 0){
             binaryList.add(number % 2);
             number = number/2;

        }
        return binaryList;
    }
}
