package _19_Trees.Questions.BFS_AND_DFS_Concepts.DFS_Iterative_Using_Stack;

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
    public void preorderDFS(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " "); // Process the current node

            // Push the right child first so that the left child is processed first
            if (node.right != null) {
                stack.push(node.right);
            }

            //we are adding left node last. so, we can remove at first. bcz in preOrder (N-L-R)
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // Iterative Inorder DFS
    public void inorderDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point
            current = stack.pop();
            System.out.print(current.val + " "); // Process the current node

            // We have visited the node and its left subtree. Now, it's right subtree's turn
            current = current.right;
        }
    }

    // Iterative Postorder DFS
    public void postorderDFS(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

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
            System.out.print(node.val + " "); // Process the current node
        }
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        DFSTraversal traversal = new DFSTraversal();

        // Perform Preorder DFS
        System.out.print("Preorder DFS Traversal: ");
        traversal.preorderDFS(root);
        System.out.println();

        // Perform Inorder DFS
        System.out.print("Inorder DFS Traversal: ");
        traversal.inorderDFS(root);
        System.out.println();

        // Perform Postorder DFS
        System.out.print("Postorder DFS Traversal: ");
        traversal.postorderDFS(root);
        System.out.println();
    }
}
