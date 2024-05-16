package _17_LinkedList.LinkedListQuestions.LinkedListRecursionQuestion;

//https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
//Reverse a Linked List in groups of given size.

//Question solve via using recursion.

class ReverseLinkedListInGroupSize {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node reverse(Node head, int k) {
        //Your code here
        if (head == null) {
            return null;
        }

        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0;

        // Reverse the first k nodes
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Recursively reverse the next group of k nodes
        if (next != null) {
            head.next = reverse(next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = null;

        // Print original linked list
        System.out.println("Original linked list:");
        printLinkedList(head);

        // Reverse in groups of size 2
        int k = 2;
        head = reverse(head, k);

        // Print reversed linked list
        System.out.println("\nReversed linked list in groups of " + k + ":");
        printLinkedList(head);
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
