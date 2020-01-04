package array.twopointer.oppositedirectional;

/**
 * @author badrikant.soni
 * problem : https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char leftRead = s.charAt(start);
            char rightRead = s.charAt(end);

            // if any special character detected, then skip current index and increment
            if (!Character.isLetterOrDigit(leftRead)) {
                start++;
                continue;
            }
            // if any special character detected, then skip current index and increment
            if (!Character.isLetterOrDigit(rightRead)) {
                end--;
                continue;
            }
            // if characters are different, mark them false.
            if ((Character.toUpperCase(leftRead) - Character.toUpperCase(rightRead)) != 0) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }
}
