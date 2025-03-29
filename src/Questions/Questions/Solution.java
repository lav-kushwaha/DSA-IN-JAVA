package Questions.Questions;

//https://www.geeksforgeeks.org/problems/binary-tree-to-dll/0
//Binary Tree to DLL
class Solution
{
    class Node
    {
        Node left, right;
        int data;

        Node(int d)
        {
            data = d;
            left = right = null;
        }

    }

    Node head = null;  
    Node prev = null;

    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        if (root == null) return null;

        bToDLL(root.left);

        if (prev == null) {
            head = root;  
        } else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;

        bToDLL(root.right);

        return head;
    }
}