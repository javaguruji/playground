package matrix;

/**
 * @author badrikant.soni
 */
public class Spiral2DArray {

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        char[][] A = new char[][]
                {
                        {'a', 'b', 'c', 'd', 'e'},
                        {'n', 'o', 'p', 'q', 'f'},
                        {'m', 't', 's', 'r', 'g'},
                        {'l', 'k', 'j', 'i', 'h'}
                };
        Spiral2DArray array = new Spiral2DArray();
        array.printSprial(A, m, n);
    }

    private void printSprial(char[][] A, int m, int n) {

        int row = 0;
        int col = 0;
        int last_row = m - 1;
        int last_col = n - 1;

        while (row <= last_row && col <= last_col) {

            // traverse right
            for (int i = col; i <= last_col; i++) {
                System.out.print(A[row][i]);
            }
            row++; // go to next row

            // traverse down
            for (int i = row; i <= last_row; i++) {
                System.out.print(A[i][last_col]);
            }
            last_col--; // go to preview column

            // traverse left
            for (int i = last_col; i >= col; i--) {
                System.out.print(A[last_row][i]);
            }
            last_row--; // go to previous row

            // traverse up
            for (int i = last_row; i >= row; i--) {
                System.out.print(A[i][col]);
            }
            col++; // go to next column
        }
    }
}
