package company.curefit;

/**
 * @author badrikant.soni
 * given a root node of complete binary tree, find no of nodes actually present in the tree.
 */
public class CountOfNodesInCompleteBinaryTree {


    private static Node createBinaryTree(int[] arr, int start, int end, Node root) {

        // check if array is empty
        if(start > end){
            return root;
        }

        // find middle element position of array
        int mid = (start + end)/2;

        // if root is empty, create root element
        if(root == null){
            root = new Node(arr[mid]);
        }

        root.left = createBinaryTree(arr, start, mid - 1, root.left);
        root.right = createBinaryTree(arr, mid + 1, end, root.right);

        return root;

    }


    public static void main(String[] args) {
        // create binary tree with below array
        int arr[] = {20, 30, 40, 50, 60, 70, 80};
        int end = arr.length - 1;
        int start = 0;
        // call function to create tree
        Node root = createBinaryTree(arr, start, end, null);

        // height of tree
        int heightOfTree = getHeightOfTree(root);
        System.out.println(heightOfTree);

        // validate BST
        boolean result = validateBST(root);
        System.out.println(result);

        // count of nodes in tree
        int nodeCount = getNodeCount(root);
        System.out.println(nodeCount);

    }

    private static int getNodeCount(Node root) {

        // base case
        if(root == null){
            return 0;
        }

        //recursive call to left child and right child and
        // add the result of these with 1 ( 1 for counting the root)
        int leftCount = getNodeCount(root.left);
        int rightCount = getNodeCount(root.right);

        return leftCount + rightCount + 1;

    }

    private static boolean validateBST(Node root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(Node root, int minValue, int maxValue) {

        if(root == null){
            return true;
        }


        if(root.data > maxValue || root.data < minValue){
            return false;
        }

        return isValidBST(root.left, minValue, root.data)
                && isValidBST(root.right, root.data, maxValue);

    }

    private static int getHeightOfTree(Node root) {

        if(root == null){
            return 0;
        }

        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);

        return Math.max(left, right) + 1;
    }


}

// create tree structure
class Node{

    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}







