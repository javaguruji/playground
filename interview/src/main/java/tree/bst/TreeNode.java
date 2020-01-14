package tree.bst;

/**
 * @author badrikant.soni
 * Time Complexity for Search and Insert
 * Wrost Case : O(h) where h is hight of tree
 *
 */
public class TreeNode {

    private int key;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int data) {
        this.key = data;
        this.left = this.right = null;
    }

    public void insert(int data) {
        if (data < this.key) {
            if (this.left != null) {
                this.left.insert(data);
            } else {
                this.left = new TreeNode(data);
            }
        } else {
            if (this.right != null) {
                this.right.insert(data);
            } else {
                this.right = new TreeNode(data);
            }
        }
    }

    public int search(int data) {
        if (data == this.key) {
            return this.key;
        }
        if (data < this.key) {
            return this.left.search(data);
        }
        return this.right.search(data);
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.key + ",");
            inorder(root.right);
        }
    }
}
