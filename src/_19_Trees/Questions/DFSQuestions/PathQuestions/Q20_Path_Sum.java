package _19_Trees.Questions.DFSQuestions.PathQuestions;

//https://leetcode.com/problems/path-sum/description/
//112. Path Sum

public class Q20_Path_Sum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // If it's a leaf node, check if the value equals targetSum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Otherwise, check the left and right subtrees with the updated targetSum
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        Q20_Path_Sum solution = new Q20_Path_Sum();

        // Create a sample tree:
        //     5
        //    / \
        //   4   8
        //  /   / \
        // 11  13  4
        // /  \      \
        //7    2      1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println("Has path sum of " + targetSum + ": " + result);

        targetSum = 26;
        result = solution.hasPathSum(root, targetSum);
        System.out.println("Has path sum of " + targetSum + ": " + result);

        targetSum = 18;
        result = solution.hasPathSum(root, targetSum);
        System.out.println("Has path sum of " + targetSum + ": " + result);

        targetSum = 5;
        result = solution.hasPathSum(root, targetSum);
        System.out.println("Has path sum of " + targetSum + ": " + result);
    }
}
