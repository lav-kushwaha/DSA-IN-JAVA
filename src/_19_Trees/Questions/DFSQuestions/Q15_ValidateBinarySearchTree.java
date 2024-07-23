package _19_Trees.Questions.DFSQuestions;

//https://leetcode.com/problems/validate-binary-search-tree/
//98. Validate Binary Search Tree

class Q15_ValidateBinarySearchTree {
    static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
       }
    }
    public boolean isValidBST(TreeNode root) {
        // Start the recursive validation with the full range of valid integer values
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        // The current node's value must be within the range defined by min and max
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively check the left and right subtrees with updated ranges
        boolean leftside = isValidBST(node.left, min, node.val);
        boolean rightside = isValidBST(node.right, node.val, max);

        return leftside && rightside;
    }

    public static void main(String[] args) {
        Q15_ValidateBinarySearchTree solution = new Q15_ValidateBinarySearchTree();

         //Test case 1: [2, 2, 2] should return false since it has duplicates
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        System.out.println(solution.isValidBST(root1));  // Should print false

         //Test case 2: [2, 1, 3] should return true
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root2));  // Should print true

        // Test case 3: [6, 4, 10, 2, 5, 8, 20, 31]
        TreeNode root3 = new TreeNode(6);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(10);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(5);
        root3.right.left = new TreeNode(8);
        root3.right.right = new TreeNode(20);
        root3.right.right.right = new TreeNode(31);
        // This test case should return true because it is a valid BST without duplicates.
        System.out.println(solution.isValidBST(root3));  // Should print true
    }
}
