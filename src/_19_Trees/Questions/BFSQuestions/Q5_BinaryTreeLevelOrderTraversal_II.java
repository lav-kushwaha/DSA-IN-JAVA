package _19_Trees.Questions.BFSQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
// 107. Binary Tree Level Order Traversal II

public class Q5_BinaryTreeLevelOrderTraversal_II {

    // Definition for a binary tree node
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            List<Integer> levelNodes = new ArrayList<>();

            //for-loop will be added every level one by one into the levelNodes arraylist.
            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
                levelNodes.add(tempNode.val);

                // Enqueue left child
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                // Enqueue right child
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

            result.add(0,levelNodes);//result = [[levelNodes]]//1st method add levelNodes to zeroth index for reverse-order or (Bottom-up level).
        }
        // Collections.reverse(result); //2nd Method.
        return result;
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

        // Perform level order traversal
        Q5_BinaryTreeLevelOrderTraversal_II tree = new Q5_BinaryTreeLevelOrderTraversal_II();
        List<List<Integer>> result = tree.levelOrderBottom(root);

        // Print the result
        System.out.println("Level order traversal of binary tree is - ");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
