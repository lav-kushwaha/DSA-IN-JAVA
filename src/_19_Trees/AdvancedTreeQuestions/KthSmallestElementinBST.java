package _19_Trees.AdvancedTreeQuestions;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//230. Kth Smallest Element in a BST

import java.util.PriorityQueue;

class KthSmallestElementinBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helper(root,minHeap,k);

        //remove k element
        int ans = 0;
        for(int i=0;i<k;i++){
            ans = minHeap.poll();
        }

        return ans;
    }

    private void helper(TreeNode node, PriorityQueue<Integer> minHeap, int k){
        if(node==null) return;
        helper(node.left,minHeap,k);
        minHeap.add(node.val);
        helper(node.right,minHeap,k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        KthSmallestElementinBST tree = new KthSmallestElementinBST();
        int k = 3; // For example, finding the 3rd smallest element
        System.out.println("The " + k + "rd smallest element is " + tree.kthSmallest(root, k));
    }
}
