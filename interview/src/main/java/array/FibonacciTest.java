package array;

/**
 * @author badrikant.soni
 */
public class FibonacciTest {

    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println(fibIterative(4));
    }

    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibIterative(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
