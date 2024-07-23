package _19_Trees.Questions.DFSQuestions;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//114. Flatten Binary Tree to Linked List

public class Q14_BinaryTreeToLinkedList {
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            // If the left subtree exists
            if (current.left != null) {
                TreeNode temp = current.left;
                // Find the rightmost node of the left subtree
                while (temp.right != null) {
                    temp = temp.right;
                }
                // Connect the rightmost node of the left subtree to the right subtree
                temp.right = current.right;
                // Move the left subtree to the right
                current.right = current.left;
                current.left = null;
            }
            // Move to the next right node
            current = current.right;
        }
    }

    // Helper method to print the tree in preorder
    public static void preorderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorderPrint(node.left);
        preorderPrint(node.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Print the original tree (preorder traversal)
        System.out.print("Original tree (preorder): ");
        preorderPrint(root);
        System.out.println();

        // Flatten the tree
        Q14_BinaryTreeToLinkedList solution = new Q14_BinaryTreeToLinkedList();
        solution.flatten(root);

        // Print the flattened tree
        System.out.print("Flattened tree: ");
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
