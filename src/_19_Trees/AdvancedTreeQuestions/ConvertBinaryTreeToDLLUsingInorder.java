package _19_Trees.AdvancedTreeQuestions;

public class ConvertBinaryTreeToDLLUsingInorder {
    LLNode head;
    LLNode tail;

    class LLNode {
        int val;
        LLNode prev;
        LLNode next;

        public LLNode(int val) {
            this.val = val;
        }
    }

   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Method to convert binary tree to doubly linked list
    public LLNode convert(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return head;
    }

    // Helper method to perform inorder traversal and build the DLL
    private void helper(TreeNode node) {
        if (node == null) return;

        helper(node.left);

        LLNode newNode = new LLNode(node.val);

        // If the DLL is empty (this is the first node)
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        helper(node.right);
    }

    public void printDLL(LLNode head) {
        LLNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ConvertBinaryTreeToDLLUsingInorder converter = new ConvertBinaryTreeToDLLUsingInorder();

        // Constructing a binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(20);

        LLNode dllHead = converter.convert(root);

        System.out.println("Doubly Linked List (Inorder traversal):");
        converter.printDLL(dllHead);
    }
}
