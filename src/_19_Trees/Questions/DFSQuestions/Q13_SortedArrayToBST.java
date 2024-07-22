package _19_Trees.Questions.DFSQuestions;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
//108. Convert Sorted Array to Binary Search Tree.

class Q13_SortedArrayToBST {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int nums[], int start, int end) {
        if (start > end) { // Base Condition or Recursion Stopping Condition
            return null;
        }

        int mid = start + (end - start) / 2; // Find the mid-value
        TreeNode root = new TreeNode(nums[mid]);//focus on root when root.left will call its become root of root.left same for root.right.
        root.left = CreateBST(nums, start, mid - 1); // Recursively build the left subtree
        root.right = CreateBST(nums, mid + 1, end); // Recursively build the right subtree
        return root; //connect the edges of left and right to the root
    }

    // Helper method to print the tree in inorder traversal (for testing purposes)
    public void printInOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Q13_SortedArrayToBST solution = new Q13_SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);

        // Print the tree to check if it is constructed correctly
        solution.printInOrder(root);
    }
}
