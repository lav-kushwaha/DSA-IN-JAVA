package _19_Trees.AdvancedTreeQuestions;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//653. Two Sum IV - Input is a BST

import java.util.HashSet;
import java.util.Set;

class TwoSumIVInputIsABST {

   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();  // HashSet to store the values of nodes
        return helper(root, set, k);         // Call the recursive helper function
    }

    private boolean helper(TreeNode root, Set<Integer> set, int target) {
        if (root == null) return false;

        if (set.contains(target - root.val)) return true;

        set.add(root.val);

        return helper(root.left, set, target) || helper(root.right, set, target);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TwoSumIVInputIsABST solution = new TwoSumIVInputIsABST();
        int target = 9;

        boolean result = solution.findTarget(root, target);
        System.out.println(result);  // Output: true
    }
}
