package tree.bst;

import java.util.Arrays;

/**
 * @author badrikant.soni
 */
// Java program to demonstrate insert operation in binary search tree
class BinarySearchTree {

    /* Class containing left and right child of current node and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    Node search(int data) {
        return findNodeInBST(root, data);
    }

    // DFS algo - recursive function
    private Node findNodeInBST(Node root, int data) {

        // Base condition
/*        if (root == null) {
            return null;
        }*/

        // condition 1
        if (null == root || data == root.key) {
            return root;
        }

        // condition 2 & 3
        if (data < root.key) {
            return findNodeInBST(root.left, data);
        } else {
            return findNodeInBST(root.right, data);
        }
    }


    // find Hight of tree

    int heightOfBST(){
        return findHeight(root);
    }

    int findHeight(Node root){
        if(root == null){
            return -1;
        }

        // give me my left
        int left = findHeight(root.left);

        // give me my right
        int right = findHeight(root.right);

        // find max of both left and right with adding 1, because we are returning -1 if null
        return 1 + Math.max(left, right);
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();
        Node search = tree.search(41);
        if (search == null) {
            System.out.println("data not found");
        } else {
            System.out.println("data found");
        }

        // find height of BST
        System.out.println(tree.heightOfBST());
    }
}

