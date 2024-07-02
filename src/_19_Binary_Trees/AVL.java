package _19_Binary_Trees;

public class AVL {

    // Nested Node class representing each node in the AVL tree
    public class Node {
        private int value;  // Value stored in the node
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

    // Root node of the AVL tree
    private Node root;

    // Constructor to initialize the AVL tree with an empty root
    public AVL(){
        this.root = null;
    }

    // Method to check if the tree is empty
    public boolean isEmpty() {
        // If the root is null, the tree is empty
        return root == null;
    }

    // Method to insert a new value into the AVL tree
    public void insert(int value) {
        root = insert(value, root); // Insert starting from the root
    }

    private Node insert(int value, Node root){
        // If the node is null, create a new node with the given value and return it
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // For left node
        if (value < root.value) {
            root.left = insert(value, root.left); // Recursively insert into the left subtree
        }

        // For right node
        if (value > root.value) {
            root.right = insert(value, root.right); // Recursively insert into the right subtree
        }

        // Return the current node after insertion
        return rotate(root);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right)>1){
            //left heavy
            //height positive
           if(height(node.left.left) - height(node.left.right)>0){
               //left left case1

               //right rotation
               return rightRotate(node);
           }

           //height negative
            if(height(node.left.left) - height(node.left.right)<0){
                //left right case2

                //left rotate
                node.left = leftRotate(node.left);

                //right rotate
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1) {
            //right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                //right-right case 3

                //left rotate
                return leftRotation(node);
            }

            //height positive
            if (height(node.left.left) - height(node.left.right) > 0) {
                //right-left case 4

                //right rotate.
                node.right = rightRotation(node.right);

                //left rotate.
                return leftRotation(node);
            }
        }

        //remaining unchnaged node.
        return node;
    }

    private Node rightRotation(Node right) {
    }

    private Node leftRotation(Node node) {
        
    }


    // Method to populate the AVL tree with a sorted array
    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length - 1);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;

        // Insert the middle element
        this.insert(nums[mid]);

        // Recursively populate the left and right subtrees
        populateSorted(nums, start, mid - 1);
        populateSorted(nums, mid + 1, end);
    }

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

    // Method to check if the tree is balanced
    public boolean balanced() {
        return balanced(root);
    }

    // Helper method to recursively check if the tree is balanced
    private boolean balanced(Node node) {
        // If the node is null, it is considered balanced
        if (node == null) {
            return true;
        }

        // If the height difference is more than 1, the tree is not balanced
        if (Math.abs(height(node.left) - height(node.right)) > 1) {
            return false;
        }

        // Recursively check if the left and right subtrees are balanced
        return balanced(node.left) && balanced(node.right);
    }

    // Method to display the tree
    public void display() {
        display(root, "Root Node : ");
    }

    // Helper method to display the tree
    private void display(Node root, String details) {
        if (root == null) {
            return;
        }

        System.out.println(details + root.getValue());

        display(root.left, "Left child of " + root.getValue() + " : ");
        display(root.right, "Right child of " + root.getValue() + " : ");
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        AVL tree = new AVL();

        // Insert nodes
        tree.insert(15);
        tree.insert(10);
        tree.insert(2);
        tree.insert(14);
        tree.insert(25);

        // Display the tree
        System.out.println("Display the tree:");
        tree.display();

        // Get the height of the tree after insertion
        System.out.println("\nHeight of the tree after insertion: " + tree.height());

        // Check if the tree is balanced after insertion
        System.out.println("\nIs the tree balanced after populating? " + tree.balanced());

        // Uncomment to test with a sorted array
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // tree.populateSorted(arr);

        // Display the tree after populating with sorted array
        // System.out.println("\nDisplay the tree after populating with sorted array:");
        // tree.display();

        // Get the height of the tree after insertion
        // System.out.println("\nHeight of the tree after insertion: " + tree.height());

        // Check if the tree is balanced after insertion
        // System.out.println("\nIs the tree balanced after populating? " + tree.balanced());
    }
}

