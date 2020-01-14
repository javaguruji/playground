package sorting.bubble;

/**
 * @author badrikant.soni
 * Design a sorting algo which can take any type of input.
 */
public class SortAnyDataType {

    public static void main(String[] args) {
/*        Integer[] intArr = {2000, 2000, 456, -10, -10,  0};
        sortArray(intArr, intArr.length);
        printArray(intArr, intArr.length);*/

        String[] strArr = {"We do nothing",
                "Hi I have something",
                "Hello Join something!",
                "(Why to do work)"};

        sortArray(strArr, strArr.length);
        printArray(strArr, strArr.length);

        Float[] floatArr = {23.4f, 11.4f, -9.7f, 11.17f};
        sortArray(floatArr, floatArr.length);
        printArray(floatArr, floatArr.length);

    }

    private static <T extends Comparable<? super T>> void sortArray(T[] objectArray, int n) {
        boolean b = true;
        while (b) {
            b = false;
            for (int i = 0; i < n - 1; i++) {
                if (objectArray[i].compareTo(objectArray[i + 1]) > 0) {
                    swap(objectArray, i, i + 1);
                    b = true;
                }
            }
        }
    }

    private static <T> void swap(T[] a, int x, int y) {
        T t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    private static <T> void printArray(T[] objectArray, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(objectArray[i]);
        }
    }
}
