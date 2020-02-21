package mygate;

/**
 * @author badrikant.soni
 */
public class SumCalculation {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        double sum = 0;
        double totalSum = 0;
        for (int j = 0; j <= n-1; j++) {
            sum = 0;
            for (int i = 0; i <= n-1; i++) {
                sum = sum + Math.floor(arr[i] / arr[j]);
            }
            totalSum = totalSum + sum;
        }
        System.out.println((int)totalSum);
    }
}
