package _19_Trees.Questions.BFS_AND_DFS_Concepts;

import java.util.LinkedList;
import java.util.Queue;


public class BreadthFirstSearch {

    static class Node{
        private final int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //root node
    private Node root;

    public BreadthFirstSearch(){
        this.root = null;
    }

    public void insert(int value){
        this.root = insert(this.root,value);
    }

    private Node insert(Node node, int value){
        if(node == null){
            //create node.
            return new Node(value);
        }

        if(value<node.value){
            node.left = insert(node.left,value);
        }

        if(value>node.value){
            node.right = insert(node.right,value);
        }
        else{
            return node;//duplicates value not allowed.
        }

        return node;
    }

    public void display(){
        levelOrderTraversal(this.root);
    }

    //Level Order Traversal (BFS)
   private void levelOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");//print value

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch tree = new BreadthFirstSearch();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);

        tree.display();
    }


}
