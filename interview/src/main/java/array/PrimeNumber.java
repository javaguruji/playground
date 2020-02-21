package array;

/**
 * @author badrikant.soni
 */
public class PrimeNumber {

    public static void main(String[] args) {

        for (int i = 2; i <= 10; i++) {
            if(isPrimeNumber(i)){
                System.out.print(i);
                System.out.print(",");
            }
        }
    }

    private static boolean isPrimeNumber(int num) {

        if(num == 2){
            return true;
        }

        for (int i = 0; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}