package _19_Trees.AdvancedTreeQuestions;

//https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
//Binary Tree to DLL

class BinaryTreeToDLL {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the binary tree
    Node root;
    Node prev = null;
    Node head = null;

    // Method to convert the binary tree to doubly linked list using inorder
    void convertToDLL(Node node) {
        // Base case: If the node is null, return
        if (node == null) {
            return;
        }

        convertToDLL(node.left);

        if (prev == null) {
            // If this is the first node (smallest node), set it as the head of the DLL
            head = node;
        } else {
            // Link the current node with the previous node
            node.left = prev;
            prev.right = node;
        }

        // Update prev to the current node
        prev = node;

        convertToDLL(node.right);
    }

    void printDLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        
        // Constructing the binary tree
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(25);

        tree.convertToDLL(tree.root);

        tree.printDLL(tree.head);
    }
}
