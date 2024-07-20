package _19_Trees.Questions.BFSQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
//102. Binary Tree Level Order Traversal(easy question)

public class Q1_BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();

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

            result.add(levelNodes);//result = [[levelNode]]
        }

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
        Q1_BinaryTreeLevelOrderTraversal tree = new Q1_BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = tree.levelOrder(root);

        // Print the result
        System.out.println("Level order traversal of binary tree is - ");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
