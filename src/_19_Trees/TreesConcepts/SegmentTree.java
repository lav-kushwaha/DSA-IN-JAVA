package _19_Trees.Concepts;

public class SegmentTree {
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    // root node
    private Node root;

    public SegmentTree(int[] arr){
        if (arr.length > 0) {
            this.root = constructTree(arr, 0, arr.length - 1);
        }
    }

    // construct tree
    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) { // base condition leaf node
            Node leaf = new Node(start, end); //leaf node interval where start==end. i.e. 0 == 0
            leaf.data = arr[start];//leaf node start arr[0] data. i.e, 3
            return leaf;//(3/0) leaf node
        }

        Node node = new Node(start, end); //node interval

        int mid = (start + end) / 2; //mid

        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data; //sum query

        return node;
    }

    // sum of query in range.(qsi = query start index, qse = query end index).
    public int query(int qsi, int qei){
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei){
        if (node == null) {
            return 0;
        }

        // case 1: node is completely inside the query range
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }

        // case 2: node is completely outside the query range
        if (node.endInterval < qsi || node.startInterval > qei) {
            return 0;
        }

        // case 3: node is partially inside and partially outside the query range.(Overlaping)
        return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
    }

    public void update(int index, int value){
        if (this.root != null) {
            update(this.root, index, value);
        }
    }

    private int update(Node node, int index, int value){
        if (node == null) {
            return 0;
        }

        // case 1: index is within the node's interval
        if (index >= node.startInterval && index <= node.endInterval) {
            // base condition: leaf node
            if (node.startInterval == node.endInterval) {
                node.data = value;
                return node.data;
            }

            int leftAns = update(node.left, index, value);
            int rightAns = update(node.right, index, value);
            node.data = leftAns + rightAns;
            return node.data;
        }

        return node.data; // case 2: if index is not within the node's interval just return the value.
    }

    // display method
    public void display(){
        if (this.root != null) {
            display(this.root);
        }
    }

    private void display(Node node){

        // Check if the node is null
        if (node == null) {
            return;
        }

        //string concatenation left,current and right node.
        String str = "";

        // Left node data display
        if (node.left != null) {
            str += "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str += "No left child => ";
        }

        // Current node data display
        str += "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        // Right node data display
        if (node.right != null) {
            str += "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str += "No right child";
        }

        // Print the constructed string
        System.out.println(str);


        // Recursive calls to display left and right children
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    public static void main(String[] args){
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println("Query (1, 6): " + tree.query(1, 6)); //sum of element between the range [1,6] is 15, 1 and 6 are index.

        tree.update(3, 10);
        System.out.println("After update: ");
        tree.display();

        System.out.println("Query (1, 6): " + tree.query(1, 6)); //after update sum of between the range become 15 to 18
    }
}
