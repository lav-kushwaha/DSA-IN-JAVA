package _19_Trees.Questions.DFSQuestions;

//https://leetcode.com/problems/diameter-of-binary-tree/
//543. Diameter of Binary Tree

class Q10_DiameterOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // The diameter through the current node (d = leftHeight + rightHeight)
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Construct the binary tree from the given input: 1,2,3,4,5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Q10_DiameterOfBinaryTree solution = new Q10_DiameterOfBinaryTree();
        int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree is: " + result);
    }
}
