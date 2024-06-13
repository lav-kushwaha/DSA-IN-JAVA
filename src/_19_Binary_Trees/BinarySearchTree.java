package _19_Binary_Trees;

public class BinarySearchTree {

    // Nested Node class representing each node in the BST
    public class Node {
        private int value;  // Value stored in the node
        private int height; // Height of the node
        private Node left;  // Left child
        private Node right; // Right child

        // Constructor to initialize the node with a value
        public Node(int value) {
            this.value = value;
        }

        // Getter for the node's value
        public int getValue() {
            return value;
        }
    }

    // Root node of the BST
    private Node root;

    // Constructor to initialize the BST with an empty root
    public BinarySearchTree(){
        this.root = null;
    }

    // Method to return the height of a given node
    public int height(Node node) {
        // If the node is null, its height is considered -1
        if (node == null) {
            return -1;
        }
        // Return the height of the node
        return node.height;
    }

    // Method to check if the tree is empty
    public boolean isEmpty() {
        // If the root is null, the tree is empty
        return root == null;
    }

    // Method to insert a new value into the BST
    public void insert(int value) {
        root = insert(value, root); // Insert starting from the root
    }

    private Node insert(int value, Node node){// (Here, Node node) initially it is root and the int value which is we are inserting.

        //if node is equal to null then it will create node and return node from the function where it called.
        if(node == null){
            node = new Node(value);
            return node;//now, this return will be return the node from where the function is called. i.e : 8
        }

        //for left node.(Here, node.value) initially, it is root value and the value which is we are inserting.
        if(value < node.value){
            //node.left is also initially null, null pass hoga tab he jaake upar, if condition true hoga aur node create hoga aur return hoga node, ye insert method ke pas, then it will insert node in node.left.
            node.left = insert(value, node.left); //i.e, now, here node.left will be null to 8.
        }

        //for right node.
        if(value > node.value){
            node.right = insert(value, node.right);
        }

        // Update the height of the current node
        node.height = Math.max(height(node.left), height(node.right)) + 1; // +1 to account for the new node

        // Return the current node after insertion
        return node;// return node from where function is called.
    }

    public boolean balanced(){
        return balanced(root);
    }

    // Helper method to recursively check if the tree is balanced
    private boolean balanced(Node node) {
        // If the node is null, it is considered balanced
        if (node == null) {
            return true;
        }

        // Calculate the height difference between left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // If the height difference is more than 1, the tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {//height should be less than or equal to 1.
            return false;
        }

        // Recursively check if the left and right subtrees are balanced
        return balanced(node.left) && balanced(node.right);
    }

    //Method to display tree.
    public void display(){
        display(root, "Root Node");
    }

    //helper method to display tree.
    private void display(Node node, String details){
        if(node == null){
            return;
        }

        System.out.println(details + node.getValue());

        display(node.left,"Left child of " + node.getValue() + " : ");

        display(node.right,"Right child of " + node.getValue() + " : ");


    }

}
