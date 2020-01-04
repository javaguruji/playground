package array.twopointer.oppositedirectional;

/**
 * @author badrikant.soni
 * problem link : https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    private static char[] reversString(char[] chars) {

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
        return chars;
    }

    private static void swap(char[] chars, int start, int end) {

        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;

    }

    public static void main(String[] args) {

        String s = "hello";
        System.out.println(reversString(s.toCharArray()));
    }
}
