package tree.bst;

/**
 * @author badrikant.soni
 */
public class Executor {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(50);
        root.insert(30);
        root.insert(20);
        root.insert(40);
        root.insert(70);
        root.insert(60);
        root.insert(80);

        root.inorder(root);

        System.out.println();
        System.out.println(root.search(40));

    }
}
