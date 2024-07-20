package _19_Trees.Questions.BFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_LevelOrderSuccessor {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode findSuccesor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
                TreeNode tempNode = queue.poll();

                // Enqueue left child
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                // Enqueue right child
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }

                if (key == tempNode.val) { 
                    break;
                }
            }
        return queue.peek();//next element of target.
    }

    public static void main(String[] args) {
        // Sample binary tree creation
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);

        Q3_LevelOrderSuccessor solution = new Q3_LevelOrderSuccessor();
        TreeNode ans = solution.findSuccesor(root,14);
        System.out.println(ans.val);

    }
}
