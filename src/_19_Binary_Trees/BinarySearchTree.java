package _19_Binary_Trees;

public class BinarySearchTree {

    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    //root node
    private Node root;

    //constructor to initialize the root value.
    public BinarySearchTree(){
        this.root = null;
    }

    //method to return height of tree.
    public int height(Node node){
        //if node is null means there is no node return height -1.
        if(node == null){
            return -1;
        }
        return node.height;
    }

    //check tree is empty or not.
    public boolean isEmpty(){
        //if root is null means tree is empty there is no node.
         return root == null;
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
