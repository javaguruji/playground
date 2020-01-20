package array;

/**
 * @author badrikant.soni
 */
public class FactorialTest {

    public static void main(String[] args) {

        System.out.println(fact(6));
        System.out.println(factIterative(6));

    }

    static int fact(int n) {

        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    static int factIterative(int n) {
        if (n == 0) return 1;
        int fact = 1;
        for (int i = n; i >= 1; --i) {
            fact = fact * i;
        }
        return fact;
    }
}
