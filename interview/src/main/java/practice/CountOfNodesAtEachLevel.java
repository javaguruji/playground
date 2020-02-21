package practice;

import java.util.Arrays;

/**
 * @author badrikant.soni
 *
 * https://stackoverflow.com/questions/12879903/binary-tree-counting-nodes-on-a-level
 *
 *
 * You traverse the tree exactly as you would normally (depth-first, in-order)
 * but you simply pass down the desired and actual level as well
 *
 * It doesn't actually traverse the entire tree since,
 * once it gets to the desired level, it can just ignore everything underneath that
 *
 */
public class CountOfNodesAtEachLevel {

    public static void main(String[] args) {


        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        Arrays.sort(arr);
        ConstructBST constructBST = new ConstructBST();
        ConstructBST.Node root = constructBST.constructBST(arr, 0, arr.length - 1, null);
        System.out.println(root.data);
        ConstructBST.inorderTraversal(root);
        System.out.println();

        for(int i = 0; i < 3; i++){
            int countAtLevel = constructBST.getCountAtLevel(root, 0,i);
            System.out.println("Level : " + i + " " + "Node Counts : " +countAtLevel);
        }
    }
}
