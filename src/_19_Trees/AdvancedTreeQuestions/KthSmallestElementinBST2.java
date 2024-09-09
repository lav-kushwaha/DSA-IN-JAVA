package _19_Trees.AdvancedTreeQuestions;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//230. Kth Smallest Element in a BST

class KthSmallestElementinBST2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private int k;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return ans;
    }

    private void helper(TreeNode node){
        if(node==null) return;
        helper(node.left);

        k--;
        if(k==0){
            ans = node.val;
            return;
        }

        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        KthSmallestElementinBST2 tree = new KthSmallestElementinBST2();
        int k = 3; // For example, finding the 3rd smallest element
        System.out.println("The " + k + "rd smallest element is " + tree.kthSmallest(root, k));
    }
}
