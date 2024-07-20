package _19_Trees.Questions.BFS_AND_DFS_Concepts;


public class DepthFirstSearch {

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Pre-order DFS (root, left, right)
    public void dfsPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        dfsPreOrder(node.left);
        dfsPreOrder(node.right);
    }

    // In-order DFS (left, root, right)
    public void dfsInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        dfsInOrder(node.left);
        System.out.print(node.val + " ");
        dfsInOrder(node.right);
    }

    // Post-order DFS (left, right, root)
    public void dfsPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        dfsPostOrder(node.left);
        dfsPostOrder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        // Construct a binary tree for demonstration
        // Example tree:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DepthFirstSearch dfs = new DepthFirstSearch();

        System.out.print("Pre-order DFS: ");
        dfs.dfsPreOrder(root);
        System.out.println();

        System.out.print("In-order DFS: ");
        dfs.dfsInOrder(root);
        System.out.println();

        System.out.print("Post-order DFS: ");
        dfs.dfsPostOrder(root);
        System.out.println();
    }
}
