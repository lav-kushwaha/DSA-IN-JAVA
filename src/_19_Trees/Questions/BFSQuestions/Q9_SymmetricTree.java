package _19_Trees.Questions.BFSQuestions;

//https://leetcode.com/problems/symmetric-tree/description/
//101. Symmetric Tree

import java.util.LinkedList;
import java.util.Queue;

class Q9_SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Method to check if a tree is symmetric (Recursive approach).
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // Method to check if a tree is symmetric (iterative approach)
    public boolean isSymmetrics(TreeNode root) {
        // A null tree is symmetric
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // Add the left and right children of the root to the queue
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){

            // Remove two nodes from the queue at once
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // Case 1: Both nodes are null, continue to next pair
            if(left==null && right==null){
                continue;
            }

            // Case 2: One of the nodes is null (asymmetric)
            if(left==null || right==null){
                return false;
            }

            // Case 3: Node values are different (asymmetric)
            if(left.val!=right.val){
                return false;
            }

            // Add children to the queue in mirror order
            // Add left child of left node and right child of right node
            queue.offer(left.left);
            queue.offer(right.right);

            // Add right child of left node and left child of right node
            queue.offer(left.right);
            queue.offer(right.left);

        }

        // If all node pairs are symmetric, return true
        return true;
    }

    public static void main(String[] args) {
        // Manually creating the tree for input root = [1, 2, 2, 3, 4, 4, 3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Q9_SymmetricTree solution = new Q9_SymmetricTree();

        //Recursive approach
        boolean result = solution.isSymmetric(root);
        System.out.println(result);  // Expected output: true

        //Iterative approach
        boolean result1 = solution.isSymmetrics(root);
        System.out.println(result1);  // Expected output: true
    }
}
