package _19_Trees.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/
//199. Binary Tree Right Side View

class Q7_BinaryTreeRightSideView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // TreeNode rightmost = null; //2nd method


            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                // rightmost = currentNode;//2nd method

                // If it's the last node in the current level, add its value to result.(1st Method)
                if (i == size - 1) {
                    result.add(currentNode.val);
                }

                // Add left child to queue if exists
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // Add right child to queue if exists
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            //size-1 added into result. (2nd Method).
            // if (rightmost != null) {
            //     result.add(rightmost.val);
            // }
        }
        return result;
    }

    public static void main(String[] args) {
        // Constructing the input tree: [1,2,3,null,5,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Creating an instance of the Q7_BinaryTreeRightSideView class
        Q7_BinaryTreeRightSideView solution = new Q7_BinaryTreeRightSideView();

        // Calling the rightSideView method to get the result
        List<Integer> result = solution.rightSideView(root);

        // Printing the result
        System.out.println("Right side view of the binary tree: " + result);
    }
}
