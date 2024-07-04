package _19_Binary_Trees;

public class AVLTree {

    public class Node {
        public int height;
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.height = 0; // Initially, a new node is at height 0
        }

        public int getValue() {
            return value;
        }
    }

    //root of avl tree
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node root) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left = insert(value, root.left);
        } else if (value > root.value) {
            root.right = insert(value, root.right);
        } else {
            return root; // Duplicate values are not allowed in AVL tree
        }

        // Update the height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Rebalance the node if needed
        return rotate(root);
    }

    private Node rotate(Node node) {

        //balance factor cannot be greater than 1 and less than -1.
        // if it's greater than 1 and less than -1 then rotate the subtree and balance it.
        int balanceFactor = height(node.left) - height(node.right);

        //BF > 1: This indicates that the left subtree is taller than the right subtree by more than one level,
        // causing the tree to be left-heavy.
        if (balanceFactor > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                return rightRotate(node); // Left-Left case
            } else {
                node.left = leftRotate(node.left); // Left-Right case
                return rightRotate(node);
            }
        }

        //BF < -1: This indicates that the right subtree is taller than the left subtree by more than one level,
        // causing the tree to be right-heavy.
        if (balanceFactor < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                return leftRotate(node); // Right-Right case
            } else {
                node.right = rightRotate(node.right); // Right-Left case
                return leftRotate(node);
            }
        }

        return node; // Node is balanced
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node T2 = c.right;

        //right rotation
        c.right = p;
        p.left = T2;

        //update the height. bcs c and p are right rotate.
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        //new node will be return which is c (after rotation c becomes parent node).
        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node T2 = p.left;

        //left rotation
        p.left = c;
        c.right = T2;

        //update the height. bcs c and p are left rotated.
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        //new node will be return which is c (after rotation p becomes parent node).
        return p;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1; // Base case: empty tree
        }
        return node.height;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        int balance = height(node.left) - height(node.right);
        if (Math.abs(balance) > 1) {
            return false;
        }

        return balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node root, String details) {
        if (root == null) {
            return;
        }

        System.out.println(details + root.getValue());

        display(root.left, "Left child of " + root.getValue() + " : ");
        display(root.right, "Right child of " + root.getValue() + " : ");
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

//        tree.insert(15);
//        tree.insert(10);
//        tree.insert(2);
//        tree.insert(14);
//        tree.insert(25);
//        tree.insert(12);
//
//        System.out.println("Display the tree:");
//        tree.display();

        for (int i=0;i<1000;i++){
            tree.insert(i);
        }

        System.out.println("\nHeight of the tree after insertion: " + tree.height());
        System.out.println("\nIs the tree balanced after populating? " + tree.balanced());
    }
}
