package string;

/**
 * @author badrikant.soni
 * Video : https://www.youtube.com/watch?v=Lj90FqNCIJE
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n)
 */
public class CountOfLongestCommonSubString {

    private static int longestCommonSubstring(char str1[], char str2[]) {

        int m = str1.length;
        int n = str2.length;

        // create 2D array for building up the matrix
        int[][] T = new int[m + 1][n + 1];

        // intialize max
        int max = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // put 0, in first row and column
                if (i == 0 || j == 0) {
                    T[i][j] = 0;

                    // if matches, increase by 1 and get maximum
                } else if (T[i - 1] == T[j - 1]) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                    max = Math.max(max, T[i][j]);

                    // if no match, put 0 in all places
                } else {
                    T[i][j] = 0;
                }
            }
        }
        return max;
    }

    private static int LCStringRecursive(char[] X, char[] Y, int m, int n, int lcsCount) {

        // Base check
        if (m <= 0 || n <= 0) {
            return lcsCount;
        }

        int lcsCount1 = lcsCount;

        // if last char matches
        if (X[m - 1] == Y[n - 1]) {
            lcsCount1 = LCStringRecursive(X, Y, m - 1, n - 1, lcsCount + 1);
        }

        // if last char of x don't match with y last char
        int lcsCount2 = LCStringRecursive(X, Y, m, n - 1, 0);

        // if last char of y don't match x last char
        int lcsCount3 = LCStringRecursive(X, Y, m - 1, n, 0);

        return Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));


    }


    public static void main(String[] args) {

        String input1 = "flow";
        String input2 = "flow";
        System.out.println(longestCommonSubstring(input1.toCharArray(), input2.toCharArray()));

        System.out.println(LCStringRecursive(input1.toCharArray(), input2.toCharArray(), input1.length(), input2.length(), 0));

    }
}
