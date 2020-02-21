package mygate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author badrikant.soni
 */
public class StringGame {

    public static void Test(String[] args) {

        String S = "abc";
        String T = "ddd";
        int k = 3;

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : S.toCharArray()) {

            int asciiValue = ch + k;
            char c = (char) asciiValue;
            stringBuilder.append(c);
            k--;
        }

        if (T.equals(stringBuilder.toString())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    public static void main(String[] args) {

        List<Integer> arr1 = new ArrayList<>(Arrays.asList(123, 543));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(321, 279));

        int[] a = new int[arr1.size()];
        int[] b = new int[arr2.size()];
        for(int i = 0 ; i < arr1.size() ; i++ ){
            a[i] = arr1.get(i);
        }

        for(int i = 0 ; i < arr1.size() ; i++ ){
            b[i] = arr2.get(i);
        }

        int aLength = a.length;
        int counter = 0;
        if (a.length != b.length) {
            throw new RuntimeException("Make sure both arrays have equal elements");
        }
        for (int i = 0; i < aLength; i++) {
            String as = String.valueOf(a[i]);
            String bs = String.valueOf(b[i]);
            for (int c = 0; c < as.length(); c++) {
                int aValue = Integer.parseInt(Character.toString(as.charAt(c)));
                int bValue = Integer.parseInt(Character.toString(bs.charAt(c)));
                if (aValue > bValue) {
                    counter += aValue - bValue;
                } else {
                    counter += bValue - aValue;
                }
            }
        }
        System.out.println(counter);
    }
}
