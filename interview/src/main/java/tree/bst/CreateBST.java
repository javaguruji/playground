package tree.bst;

import java.util.Arrays;

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

        int[] arr = new int[]{99, 35, 19, 0, 11, 40, 5};
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

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + ",");
            inorder(root.right);
        }
    }
}
