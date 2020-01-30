package tree.bst.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author badrikant.soni
 */
public class TreeTraverse {

    static class Node {
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.visited = false;
        }

        int data;
        Node left;
        Node right;
        boolean visited;
    }

    public static void main(String[] args) {
        //The tree:
        //   1
        //  / \
        // 7   9
        // \  / \
        //  8 2 3

        Node node1 = new Node(1);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node7;
        node1.right = node9;
        node7.right = node8;
        node9.right = node3;
        node9.left = node2;
        System.out.println("DFS: ");
        depthFirstSearch(node1);
        System.out.println("\nBFS: ");
        breadthFirstSearch(node1);
        System.out.println("\nBFS Recursive: ");

        int i = BFSRecursive(node1);
        System.out.println(i);

    }

    private static void depthFirstSearch(Node node) {
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            node.visited = true;
        } else if (node.left == null || node.left.visited) {
            depthFirstSearch(node.right);
            System.out.print(node.data + " ");
            node.visited = true;
        } else {
            depthFirstSearch(node.left);
            node.visited = true;
            System.out.print(node.data + " ");
            depthFirstSearch(node.right);

        }
    }

    private static void breadthFirstSearch(Node node) {
        List<Node> al = new ArrayList<>();
        al.add(node);
        while (!al.isEmpty()) {
            node = al.get(0);
            if (node.left != null) {
                int index = al.size();
                al.add(index, node.left);
            }
            if (node.right != null) {
                int index = al.size();
                al.add(index, node.right);
            }
            System.out.print(al.get(0).data + " ");
            al.remove(0);
        }
    }


    // complexity : O(n) , Space Compexity : O(n)
    // System.out.println("Level order traversal of binary tree is - ");
    private static int BFSRecursive(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){

            // remove the present node from head
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if(tempNode.left!=null){
                queue.add(tempNode.left);
                count++;
            }

            if(tempNode.right!=null){
                queue.add(tempNode.right);
                count++;
            }

        }

        return count + 1;

    }
}
