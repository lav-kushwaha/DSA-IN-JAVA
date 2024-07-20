package _19_Trees.Questions.DFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
//104. Maximum Depth of Binary Tree

class Q12_MaximumDepthOfBinaryTree {

    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }

    }

    // Method to calculate the maximum depth of a binary tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively find the maximum depth of the left and right subtrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // The maximum depth of the current node is the greater of the two depths plus one
        return Math.max(left, right) + 1;
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
        // Construct a binary tree for demonstration
        // Example tree:
        //      4
        //     / \
        //    2   7
        //   / \ / \
        //  1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Q12_MaximumDepthOfBinaryTree solution = new Q12_MaximumDepthOfBinaryTree();

        // Print the tree (optional, for verification)
        System.out.print("Tree: ");
        solution.printTree(root);

        // Calculate the maximum depth of the binary tree
        int maxDepth = solution.maxDepth(root);
        System.out.println("Maximum depth of the binary tree is: " + maxDepth);
    }
}

