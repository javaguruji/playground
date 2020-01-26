package tree.bst;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author badrikant.soni
 */
public class CreateBST {

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

    public static void main(String[] args) {

        //int[] arr = new int[]{99, 35, 19, 0, 11, 40, 5};
        //int[] arr = new int[]{30, 20, 50, 40, 60, 70, 80};
        int[] arr = new int[]{4, 2, 7, 1, 3, 6, 9};
        Node root = null;
        Arrays.sort(arr);
        for (int a : arr) {
            System.out.print(a + ",");
        }
        int start = 0;
        int end = arr.length - 1;
        root = constructBST(arr, start, end, root);
        System.out.println();
        System.out.println("root node data  : " + root.data);
        inorder(root);
        invertBinaryTree(root);
        inorder(root);
        Node search = search(30, root);
        System.out.println();
        if (search == null) {
            System.out.println("data not found");
        } else {
            System.out.println("data found");
        }

        // search with iterative function
        System.out.println(searchWithIterative(35, root));

        System.out.println(findMaxforN(root, 36));

        postOrderIterative(root);

    }

    private static Node constructBST(int[] arr, int start, int end, Node root) {
        // base case
        if (start > end) {
            return root;
        }

        // find mid element of array
        int mid = (start + end) / 2;

        // create root if not present
        if (root == null) {
            root = new Node(arr[mid]);
        }

        // insert element by recursion
        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;
    }

    // finding an element recursive function
    private static Node search(int data, Node root) {
        if (root == null) {
            return null;
        }
        if (data == root.data) {
            return root;
        }

        if (data < root.data) {
            return search(data, root.left);
        } else {
            return search(data, root.right);
        }
    }


    // finding an element with iterative function
    private static boolean searchWithIterative(int data, Node root){

        while(root != null){
            if(data < root.data){
                root = root.left;
            }else if(data > root.data){
                root = root.right;
            }else {
                return true;
            }
        }
        return false;
    }

    // function to find max value less then N
    static int findMaxforN(Node root, int N)
    {
        // Base cases
        if (root == null)
            return -1;
        if (root.data == N)
            return N;

            // If root's value is smaller, try in rght
            // subtree
        else if (root.data < N) {
            int k = findMaxforN(root.right, N);
            if (k == -1)
                return root.data;
            else
                return k;
        }

        // If root's key is greater, return value
        // from left subtree.
        else if (root.data > N)
            return findMaxforN(root.left, N);
        return -1;
    }

    // recursive function
    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + ",");
            inorder(root.right);
        }
    }

    // recursive function
    private static void preorder(Node root){
        if(root!= null){
            System.out.println(root.data + ",");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // recursive function
    private static void postOrder(Node root){
        if(root!= null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + ",");
        }
    }

    // preorder iterative function
    private static void preorderIterative(Node root){

        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()){

            Node newNode = stack.peek();
            System.out.print(newNode.data + ",");
            stack.pop();

            if(newNode.right != null){
                stack.push(newNode.right);
            }

            if(newNode.left !=null){
                stack.push(newNode.left);
            }

        }
    }

    private static void postOrderIterative(Node root)
    {
        // Create two stacks
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        if (root == null)
            return;

        // push root to first stack
        s1.push(root);

        // Run while first stack is not empty
        while (!s1.isEmpty()) {
            // Pop an item from s1 and push it to s2
            Node temp = s1.pop();
            s2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        // Print all elements of second stack
        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }

    private static Node invertBinaryTree(Node root){

        if(root == null){
            return root;
        }

        Node left = invertBinaryTree(root.left);
        Node right = invertBinaryTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

}
