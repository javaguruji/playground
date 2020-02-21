package mygate;

import java.util.Scanner;

/**
 * @author badrikant.soni
 */
public class Test {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = in.nextInt();
            for (int i = 1; i <= arr[j]; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }

        }
        in.close();
    }
}
