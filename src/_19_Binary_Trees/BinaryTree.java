package _19_Binary_Trees;

import java.util.Scanner;

public class BinaryTree {

    // Node class representing each node in the binary tree
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root; // Root node of the binary tree

    // Constructor to initialize an empty binary tree
    public BinaryTree() {
        this.root = null;
    }

    // Method to populate the binary tree from user input
    public void populate(Scanner scanner) {
        System.out.println("Enter the value of the root node:");
        int value = scanner.nextInt();
        root = new Node(value);

        populate(scanner, root); // Start populating recursively from the root
    }

    // Private recursive method to populate the binary tree
    private void populate(Scanner scanner, Node node) {
        // Prompt user for left child
        System.out.println("Do you want to enter the left child of " + node.value + "? (true/false)");
        boolean hasLeft = scanner.nextBoolean();
        if (hasLeft) {
            System.out.println("Enter the value of the left child of " + node.value + ":");
            int leftValue = scanner.nextInt();
            node.left = new Node(leftValue);
            populate(scanner, node.left); // Recursively populate left subtree
        }

        // Prompt user for right child
        System.out.println("Do you want to enter the right child of " + node.value + "? (true/false)");
        boolean hasRight = scanner.nextBoolean();
        if (hasRight) {
            System.out.println("Enter the value of the right child of " + node.value + ":");
            int rightValue = scanner.nextInt();
            node.right = new Node(rightValue);
            populate(scanner, node.right); // Recursively populate right subtree
        }
    }

    // Method to display the binary tree
    public void display() {
        display(root, ""); // Call the private display method with an empty indent
    }

    // Private recursive method to display the binary tree with proper indentation
    private void display(Node node, String indent) {
        if(node == null){
            return;
        }

        // Print the current node's value with indentation.
        System.out.println(indent + node.value);

        // Print the left subtree with proper indentation.
        display(node.left,indent + "\t"); // "\t" means tab.

        // Print the right subtree with proper indentation.
        display(node.right, indent + "\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root," ",true);
    }

    private void prettyDisplay(Node node, String indent, boolean last){

        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└── ");
                indent += "    ";
            } else {
                System.out.print("├── ");
                indent += "│   ";
            }
            System.out.println(node.value);

            prettyDisplay(node.left, indent, false);
            prettyDisplay(node.right, indent, true);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner); // Populate the binary tree from user input
        tree.display(); // Display the binary tree
        tree.prettyDisplay();// Display the binary tree with nodes and pointers
    }
}
