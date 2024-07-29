package _19_Trees.Questions.DFSQuestions.PathQuestions;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
//129. Sum Root to Leaf Numbers

public class Q21_SumRoottoLeafNumbers {
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    int sum = 0;  // to store the total sum of all root-to-leaf numbers

    public int sumNumbers(TreeNode root) {
        helper(root, "");  // start the helper function with an empty string
        return sum;  // return the total sum
    }

    private void helper(TreeNode root, String str) {
        if (root == null) return;  // base case: if the current node is null, return

        str = str + root.val;  // append the current node's value to the path string

        // If the current node is a leaf, convert the path string to an integer and add it to sum
        if (root.left == null && root.right == null) {
            sum = sum + Integer.parseInt(str);
            return;  // return since it's a leaf node
        }

        // Recursively call the helper function for left and right children
        helper(root.left, str);
        helper(root.right, str);
    }

    public static void main(String[] args) {
        // Manually create the tree structure: [4, 9, 0, 5, 1]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Q21_SumRoottoLeafNumbers solution = new Q21_SumRoottoLeafNumbers();
        int result = solution.sumNumbers(root);
        System.out.println("The sum of all root-to-leaf numbers is: " + result);  // Output should be 1026
    }
}


//2nd method
//class Solution {
//    public int sumNumbers(TreeNode root) {
//        helper(root,0);  // start the helper function with an empty string
//        return sum;  // return the total sum
//    }
//
//    private int helper(TreeNode root, int sum) {
//        if (root == null) return;  // base case: if the current node is null, return
//
//        sum = sum * 10 + root.val;  // append the current node's value to the path string
//
//        // If the current node is a leaf, convert the path string to an integer and add it to sum
//        if (root.left == null && root.right == null) {
//            return sum;  // return since it's a leaf node
//        }

//        Recursively call the helper function for left and right children
//        return helper(root.left, num) + helper(root.right, num);
//    }
//}
