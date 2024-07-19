package _19_Trees.TreesConcepts;

import java.util.LinkedList;
import java.util.Queue;


public class TreeTraversalMethods {
   static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    // DFS (Depth-First Search)
    // Preorder traversal (DFS: Root-Left-Right)
    void preorderTraversal(Node node) {
        if (node == null)
            return;

        // Visit the root
        System.out.print(node.data + " ");
        // Recur on the left subtree
        preorderTraversal(node.left);
        // Recur on the right subtree
        preorderTraversal(node.right);
    }

    // Inorder traversal (DFS: Left-Root-Right)
    void inorderTraversal(Node node) {
        if (node == null)
            return;

        // Recur on the left subtree
        inorderTraversal(node.left);
        // Visit the root
        System.out.print(node.data + " ");
        // Recur on the right subtree
        inorderTraversal(node.right);
    }

    // Postorder traversal (DFS: Left-Right-Root)
    void postorderTraversal(Node node) {
        if (node == null)
            return;

        // Recur on the left subtree
        postorderTraversal(node.left);
        // Recur on the right subtree
        postorderTraversal(node.right);
        // Visit the root
        System.out.print(node.data + " ");
    }

    //BFS (Breadth-First Search)
    // Level order traversal (BFS: Breadth-First)
    void levelOrderTraversal(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeTraversalMethods tree = new TreeTraversalMethods();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal (DFS):");
        tree.preorderTraversal(tree.root);

        System.out.println("\nInorder traversal (DFS):");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPostorder traversal (DFS):");
        tree.postorderTraversal(tree.root);

        System.out.println("\nLevel order traversal (BFS):");
        tree.levelOrderTraversal(tree.root);
    }
}
