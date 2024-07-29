package _19_Trees.Questions.DFSQuestions.PathQuestions;

public class Q23_PathExistsInBinaryTreeFromRootToLeaf {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean findPath(TreeNode node, int[] arr) {
        if (node == null) {
            return arr.length == 0;
        }
        return helper(node, arr, 0);
    }

    boolean helper(TreeNode node, int[] arr, int index) {
        if (node == null) {
            return false;
        }

        // if index is greater or equal to arr.length or node.val is not equal to arr element return false.
        if (index >= arr.length || node.val != arr[index]) {
            return false;
        }

        // from leaf node
        if (node.left == null && node.right == null && index == arr.length - 1) {
            return true;
        }

        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }

    public static void main(String[] args) {
        // Create the tree root = 3,5,null,null,9,10,12,16,null,8,null
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(12);
        root.right.right.left = new TreeNode(16);
        root.right.right.right = new TreeNode(8);

        // Array to check the path
        int[] arr = {3, 9, 12, 8};

        Q23_PathExistsInBinaryTreeFromRootToLeaf finder = new Q23_PathExistsInBinaryTreeFromRootToLeaf();
        boolean exists = finder.findPath(root, arr);

        System.out.println("Path exists: " + exists);
    }
}
