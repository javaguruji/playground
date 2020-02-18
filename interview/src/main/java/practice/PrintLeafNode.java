package practice;

import java.util.Arrays;

/**
 * @author badrikant.soni
 *
 * 1) If given node is null then return
 * 2) If both left and right nodes are null, it means its leaf node, so print its value.
 * 3) Recursively visit the left and right subtree.
 *
 * Read more: https://javarevisited.blogspot.com/2016/09/how-to-print-all-leaf-nodes-of-binary-tree-in-java.html#ixzz6E7pZNCh7
 *
 *
 * Here are the steps to print leaf nodes of binary tree without recursion
 * 1) Create a Stack and push the root node
 * 2) loop until Stack is not empty
 * 3) Call Stack.pop() to get the last element and store its left and right child if they are not null
 * 4) if both left and right child of the last node is null then it's a leaf node, print its value
 *
 * Read more: https://javarevisited.blogspot.com/2016/09/how-to-print-all-leaf-nodes-of-binary-tree-in-java.html#ixzz6E7sCSEoA
 *
 */
public class PrintLeafNode {

    public static void main(String[] args) {

        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        Arrays.sort(arr);
        ConstructBST constructBST = new ConstructBST();
        ConstructBST.Node root = constructBST.constructBST(arr, 0, arr.length - 1, null);
        constructBST.printLeafNodes(root);
        System.out.println();
        constructBST.printLeafNodesWithoutRecursion(root);
    }
}
