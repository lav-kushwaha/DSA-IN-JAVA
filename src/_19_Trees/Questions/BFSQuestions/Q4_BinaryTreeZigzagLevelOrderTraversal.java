package _19_Trees.Questions.BFSQuestions;
import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//103. Binary Tree Zigzag Level Order Traversal.

class Q4_BinaryTreeZigzagLevelOrderTraversal {
    static class TreeNode {
       private int val;
       private TreeNode left;
       private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();

                //Normal Order
                if (leftToRight) {
                    list.add(tempNode.val);
                } else {
                    //RightToLeft(Reverse)
                    list.add(0, tempNode.val);  // Add to the beginning of the list
                }

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

            result.add(list);
            leftToRight = !leftToRight;  // Toggle the direction
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        System.out.println(result);
    }
}
