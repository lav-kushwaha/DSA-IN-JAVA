package _19_Trees.Questions.DFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/invert-binary-tree/description/
//226. Invert Binary Tree

class Q11_InvertBinaryTree {
    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }

    }
    // Method to invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right children of the current node
        root.left = right;
        root.right = left;

        return root;
    }

    // Helper method to print the tree in level order (for verification)
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Construct the binary tree from the given input: 4,2,7,1,3,6,9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Create an instance of the Q11_InvertBinaryTree class
        Q11_InvertBinaryTree solution = new Q11_InvertBinaryTree();

        // Print the original tree
        System.out.print("Original tree: ");
        solution.printTree(root);

        // Invert the binary tree
        TreeNode invertedRoot = solution.invertTree(root);

        // Print the inverted tree
        System.out.print("Inverted tree: ");
        solution.printTree(invertedRoot);
    }
}
