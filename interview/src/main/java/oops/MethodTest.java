package oops;

import java.util.Arrays;

/**
 * @author badrikant.soni
 */
public class MethodTest {

    public static void main(String[] args) {

        int a = 5;
        int b = 7;

        int[] swap = swap(a, b);
        System.out.println(a);
        System.out.println(b);
        System.out.println("-----------------");
        Arrays.stream(swap).forEach(value -> System.out.println(value));

    }

    private static int[] swap(int a, int b) {
        int[] result = new int[2];
        int temp;
        temp = a;
        a = b;
        b = temp;
        result[0] = a;
        result[1] = b;
        return result;
    }
}
