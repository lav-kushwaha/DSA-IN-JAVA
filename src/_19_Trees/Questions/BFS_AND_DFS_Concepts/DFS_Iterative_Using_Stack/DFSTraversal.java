package _19_Trees.Questions.BFS_AND_DFS_Concepts.DFS_Iterative_Using_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Iterative Preorder DFS
    public List<Integer> preorderDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val); // Add the current node value to the result list

            // Push the right child first so that the left child is processed first
            if (node.right != null) {
                stack.push(node.right);
            }

            // Add left node last so it is processed first
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    // Iterative Inorder DFS
    public List<Integer> inorderDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node (Left Traversal)
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point
            current = stack.pop();
            result.add(current.val); // Add the current node value to the result list

            // Move to the right subtree
            current = current.right;
        }

        return result;
    }

    // Iterative Postorder DFS
    public List<Integer> postorderDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();// Stack for processing nodes
        Stack<TreeNode> stack2 = new Stack<>();//Stack to help with post-order traversal
        stack1.push(root);// Start with the root node

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            result.add(node.val); // Add the current node value to the result list
        }

        return result;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(12);

        //left subtree
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);

        //right subtree
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(18);

        DFSTraversal traversal = new DFSTraversal();

        // Perform Preorder DFS
        System.out.println("Preorder DFS Traversal: " + traversal.preorderDFS(root));

        // Perform Inorder DFS
        System.out.println("Inorder DFS Traversal: " + traversal.inorderDFS(root));

        // Perform Postorder DFS
        System.out.println("Postorder DFS Traversal: " + traversal.postorderDFS(root));
    }
}
