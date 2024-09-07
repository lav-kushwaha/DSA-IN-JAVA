package Questions.SEP;

//https://leetcode.com/problems/linked-list-in-binary-tree/
//1367. Linked List in Binary Tree

public class LinkedListInBT {
   static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Definition for a binary tree node.
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        if(root.val == head.val) {
            if(helper(head,root)) return true;
        }
        return isSubPath(head,root.left) || isSubPath(head, root.right);
    }

    public boolean helper(ListNode head, TreeNode node) {
        if(head==null) return true;
        if(node==null || head.val!=node.val) return false;

        return helper(head.next,node.left) || helper(head.next, node.right);
    }

    public static void main(String[] args) {
        // Example usage:
        // Creating the linked list: [4, 2, 8]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(6);
        root.left.left.right = new TreeNode(1);
        root.right.left.left = new TreeNode(8);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(3);

        LinkedListInBT solution = new LinkedListInBT();
        boolean result = solution.isSubPath(head, root);
        System.out.println(result); // Output: true
    }
}
