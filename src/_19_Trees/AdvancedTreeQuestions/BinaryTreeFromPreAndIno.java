package _19_Trees.AdvancedTreeQuestions;

import java.util.HashMap;

public class BinaryTreeFromPreAndIno {

    // Definition for a binary tree node
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for creating a new TreeNode with a value
        TreeNode(int val) {
            this.val = val;
        }

        // Constructor for creating a TreeNode with left and right children
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int preIndex = 0;
    // HashMap to store value-to-index mapping for the inorder array
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Recursively build the binary tree
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        // Get the current root value from preorder and increment the preorder index
        int rootValue = preorder[preIndex++];
        TreeNode node = new TreeNode(rootValue);

        node.left = arrayToTree(preorder, left, map.get(rootValue) - 1);
        node.right = arrayToTree(preorder, map.get(rootValue) + 1, right);

        return node;
    }

    // Helper function to print the tree in inorder traversal to verify the result
    public void printInorder(TreeNode node) {
        if (node == null) return;

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeFromPreAndIno solution = new BinaryTreeFromPreAndIno();

        // Test Case 1: Example from the problem statement
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);

        System.out.print("Inorder traversal of the constructed tree: ");
        solution.printInorder(root1);  // Output should match the original inorder array: 9 3 15 20 7
    }
}
