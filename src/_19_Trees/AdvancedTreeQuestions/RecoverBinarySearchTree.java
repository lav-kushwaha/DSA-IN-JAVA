package _19_Trees.AdvancedTreeQuestions;

//https://leetcode.com/problems/recover-binary-search-tree/
//99. Recover Binary Search Tree or Two Node Swapped

public class RecoverBinarySearchTree {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public class TwoNodeSwappedInTree {
        Node first;
        Node second;
        Node prev;

        public void recoverTree(Node root) {
            first = second = prev = null;
            helper(root);

            // Swap the values of the two nodes
            if (first != null && second != null) {
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
        }

        private void helper(Node root) {
            InorderTraversal(root);
        }

        private void InorderTraversal(Node node) {
            if (node == null) {
                return;
            }

            InorderTraversal(node.left);

            // Detect the first and second nodes that are out of order
            if (prev != null && prev.val > node.val) {
                if (first == null) {
                    first = prev;
                }
                second = node;
            }
            prev = node;

            InorderTraversal(node.right);
        }
    }

    public void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree tree = new RecoverBinarySearchTree();
        TwoNodeSwappedInTree recover = tree.new TwoNodeSwappedInTree();

        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);  // Swapped nodes are 3 and 2

        System.out.println("Original tree (in-order):");
        tree.printInOrder(root);

        // Recover the tree
        recover.recoverTree(root);

        System.out.println("\nRecovered tree (in-order):");
        tree.printInOrder(root);
    }
}
