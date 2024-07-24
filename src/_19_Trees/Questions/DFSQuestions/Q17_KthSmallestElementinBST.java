package _19_Trees.Questions.DFSQuestions;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//230. Kth Smallest Element in a BST

class Q17_KthSmallestElementinBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        //using concept of inorder traversals.

        int left = kthSmallest(root.left, k);

        // If left is not equal to 0 means we found our answer.
        if (left != 0) {
            return left;
        }

        count = count + 1;

        // If k is equal to count, we found our answer. Return current node value.
        if (k == count) return root.val;

        // Otherwise, check the right side.
        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        Q17_KthSmallestElementinBST tree = new Q17_KthSmallestElementinBST();
        int k = 3; // For example, finding the 3rd smallest element
        System.out.println("The " + k + "rd smallest element is " + tree.kthSmallest(root, k));
    }
}
