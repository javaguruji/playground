package practice;

import java.util.Arrays;

/**
 * @author badrikant.soni
 */
public class InvertBST {

    public static void main(String[] args) {

        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        Arrays.sort(arr);
        ConstructBST constructBST = new ConstructBST();
        ConstructBST.Node root = constructBST.constructBST(arr, 0, arr.length - 1, null);
        constructBST.invertBST(root);
        ConstructBST.inorderTraversal(root);

    }
}
