package _19_Trees.Questions.BFSQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//637. Average of Levels in Binary Tree
//https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

class Q2_AverageOfLevelsInBinaryTree {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(); // empty list
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
                sum += tempNode.val; // sum of levels

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            double avg = sum / levelSize; // calculate average
            ans.add(avg);
        }
        return ans;
    }

    public static void main(String[] args) {
        // Sample binary tree creation
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Calculate average of levels
        Q2_AverageOfLevelsInBinaryTree solution = new Q2_AverageOfLevelsInBinaryTree();
        List<Double> result = solution.averageOfLevels(root);

        // Print the result
        System.out.println("Average of levels in binary tree is - ");
        for (Double avg : result) {
            System.out.println(avg);
        }
    }
}
