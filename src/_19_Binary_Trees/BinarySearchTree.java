package _19_Binary_Trees;

public class BinarySearchTree {

    // Nested Node class representing each node in the BST
    public class Node {
        private int value;  // Value stored in the node
//        private int height; // Height of the node
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

//    // Method to return the height of a given node
//    public int height(Node node) {
//        // If the node is null, its height is considered -1
//        if (node == null) {
//            return -1;
//        }
//        // Return the height of the node
//        return node.height;
//    }


    // Calculate the height of the tree
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
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

    private Node insert(int value, Node root){// (Here, Node node) initially it is root and the int value which is we are inserting.

        //if node is equal to null then it will create node and return node from the function where it called.
        if(root == null){
            root = new Node(value);
            return root;//now, this return will be return the node from where the function is called. i.e : 8
        }

        //for left node.(Here, node.value) initially, it is root value and the value which is we are inserting.
        if(value < root.value){
            //node.left is also initially null, null pass hoga tab he jaake upar, if condition true hoga aur node create hoga aur return hoga node, ye insert method ke pas, then it will insert node in node.left.
            root.left = insert(value, root.left); //i.e, now, here node.left will be null to 8.
        }

        //for right node.
        if(value > root.value){
            root.right = insert(value, root.right);
        }

        // Update the height of the current node
//        root.height = Math.max(height(root.left), height(root.right)) + 1; // +1 to account for the new node

        // Return the current node after insertion. (Return the (unchanged) node pointer)
        return root;// return node from where function is called.
    }

    // Method to populate the BST with a sorted array
    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length-1);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start > end){
            return;
        }

        int mid = (start + end) / 2;

        // Insert the middle element
        this.insert(nums[mid]);

        // Recursively populate the left and right subtrees
        populateSorted(nums, start, mid-1);
        populateSorted(nums, mid + 1, end);
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

        // If the height difference is more than 1, the tree is not balanced
        if (Math.abs(height(node.left) - height(node.right)) > 1) {//height should be less than or equal to 1.
            return false;
        }

        // Recursively check if the left and right subtrees are balanced
        return balanced(node.left) && balanced(node.right);
    }

    //Method to display tree.
    public void display(){
        display(root, "Root Node : ");
    }

    //helper method to display tree.
    // Method to perform preorder traversal and print the values.
    private void display(Node root, String details){
        if(root == null){
            return;
        }

        System.out.println(details + root.getValue());

        display(root.left,"Left child of " + root.getValue() + " : ");

        display(root.right,"Right child of " + root.getValue() + " : ");

    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes
        tree.insert(15);
        tree.insert(10);
        tree.insert(2);
        tree.insert(14);
        tree.insert(25);
//        tree.insert(60);
//        tree.insert(80);

        // Display the tree
        System.out.println("Display the tree:");
        tree.display();

        // Get the height of the tree after insertion
        System.out.println("\nHeight of the tree after insertion: " + tree.height());

        // Check if the tree is balanced after insertion
        System.out.println("\nIs the tree balanced after populating? " + tree.balanced());


       //=====================================Sorted Array======================================================

//        // Check if the tree is balanced before insertion
//        System.out.println("Is the tree balanced? " + tree.balanced());

//        // Get the height of the tree before insertion
//        System.out.println("Height of the tree before insertion: " + tree.height());

        // Populate the tree with a sorted array
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        tree.populateSorted(arr);
//
//        // Display the tree after populating with sorted array
//        System.out.println("\nDisplay the tree after populating with sorted array:");
//        tree.display();

        // Get the height of the tree after insertion
//        System.out.println("\nHeight of the tree after insertion: " + tree.height());
//
//        // Check if the tree is balanced after insertion
//        System.out.println("\nIs the tree balanced after populating? " + tree.balanced());
    }
}

