package string;

/**
 * @author badrikant.soni
 */
public class StringWithMultipleSpace {

    public static void main(String[] args) {

        String input = "HOW ARER YOU";
        //printVertically(input);
        toVerticalWords(input);
    }

    private static void printVertically(String input) {

        String[] arr = input.split(" ");
        char[] s1 = arr[0].toCharArray();
        char[] s2 = arr[1].toCharArray();
        char[] s3 = arr[2].toCharArray();
        int len = arr[0].length();
        for (int i = 0; i < len; i++) {
            System.out.print(s1[i]);
            System.out.print(s2[i]);
            System.out.print(s3[i]);
            System.out.println();
        }
    }

    private static void toVerticalWords(String str) {
        String[] words = str.split("\\s+");
        boolean remained = true;

        for (int i = 0; remained; i++) {
            remained = false;
            for (String word : words) {

                remained = remained || (word.length() > i);

                if(word.length() > i){
                    System.out.print(word.charAt(i));
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
