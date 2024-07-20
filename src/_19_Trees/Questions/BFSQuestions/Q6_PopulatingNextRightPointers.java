package _19_Trees.Questions.BFSQuestions;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//116. Populating Next Right Pointers in Each Node(Asked in Amazon california)

class Q6_PopulatingNextRightPointers {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;


        public Node(int _val) {
            val = _val;
        }
    }
    public Node connect(Node root) {
        if(root==null) return null;

        Node leftMost = root; // Start with the root node

        // Continue until we reach the bottom of the tree
        while(leftMost.left!=null){
            Node current = leftMost; // Start at the beginning of the current level
            // Traverse the current level till its become null.
            while(current!=null){
                // Connect the left child to the right child
                current.left.next = current.right;

                // Connect the right child to the next subtree's left child
                if(current.next!=null){
                    current.right.next = current.next.left; //bridge
                }

                // Move to the next node in the current level
                current = current.next;
            }

            // Move to the next level
            leftMost = leftMost.left;
        }
        return root;
    }

    // Utility method to print the tree levels with next pointers
    public void printTree(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                System.out.print(current.val + " -> ");
                if (current.next != null) {
                    System.out.print(current.next.val + " ");
                } else {
                    System.out.print("null ");
                }
                current = current.next;
            }
            System.out.println();
            levelStart = levelStart.left;
        }
    }
    
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        Q6_PopulatingNextRightPointers solution = new Q6_PopulatingNextRightPointers();
        
        // Connect next pointers
        solution.connect(root);
        
        // Print the tree levels with next pointers
        solution.printTree(root);
    }
}
