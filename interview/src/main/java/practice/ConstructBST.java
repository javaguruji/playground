package practice;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author badrikant.soni
 */
public class ConstructBST {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node constructBST(int[] arr, int start, int end, Node root) {

        if (start > end) {
            return root;
        }
        int mid = (start + end) / 2;
        if (root == null) {
            root = new Node(arr[mid]);
        }

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }


    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data);
            inorderTraversal(root.right);
        }

    }

    public int getCountAtLevel(Node root, int currentLevel, int desiredLevel) {

        if (root == null) {
            return 0;
        }

        if (currentLevel == desiredLevel) {
            return 1;
        }

        // DFS
        int countAtLevelForLeftTree = getCountAtLevel(root.left, currentLevel + 1, desiredLevel);
        int countAtLevelForRightTree = getCountAtLevel(root.right, currentLevel + 1, desiredLevel);

        return countAtLevelForLeftTree + countAtLevelForRightTree;

    }


    public int heightOfBST(Node root) {

        if (root == null) {
            return 0;
        }

        int left = heightOfBST(root.left);
        int right = heightOfBST(root.right);

        return Math.max(left, right) + 1;

    }

    public Node invertBST(Node root){

        Node temp = null;
        if(root == null){
            return root;
        }

        root.left = invertBST(root.left);
        root.right = invertBST(root.right);

        temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public void printLeafNodes(Node root){

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            System.out.println(root.data);
        }

        printLeafNodes(root.left);
        printLeafNodes(root.right);

    }

    public void printLeafNodesWithoutRecursion(Node root1){

        Stack<Node> stack = new Stack<>();
        stack.push(root1);

        while(!stack.isEmpty()){
            Node root = stack.pop();

            if(root.right != null){
                stack.push(root.right);
            }

            if(root.left != null){
                stack.push(root.left);
            }

            if(root.left == null && root.right == null){
                System.out.println(root.data);
            }

        }

    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        Arrays.sort(arr);
        ConstructBST constructBST = new ConstructBST();
        Node root = constructBST.constructBST(arr, 0, arr.length - 1, null);
        System.out.println(root.data);
        inorderTraversal(root);

    }

}
