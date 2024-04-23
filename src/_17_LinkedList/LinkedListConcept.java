package _17_LinkedList;

public class LinkedListConcept {
    // Every linked list has a head and tail.
    // Private because we don't want to access anyone.
    private Node head; // Head of the linked list.
    private Node tail; // Tail of the linked list.

    private int size;

    // Constructor
    public LinkedListConcept() {
        this.size = 0;
    }

    // Method to add a new node at the beginning of the linked list
    public void insertFirst(int val) {
        // Inserting new node
        Node newNode = new Node(val);
        // New node pointing to the next node, but the problem is now head position is 2nd.
        newNode.next = head;
        // Here head comes to the first position.
        head = newNode;

        // If the list was empty, update the tail reference as well
        if (tail == null) {
            tail = head;
        }

        // Increase the size.
        size++;
    }

    // Method to print all elements of the linked list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Node - which has a value and next node.
    // Private because we don't want to access anyone.
    private class Node {

        private int value; // By default node value is null.
        private Node next; // By default node value is null.

        // Constructor
        public Node(int value) {
            this.value = value;
        }

        // Constructor
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }



    }

    public static void main(String[] args) {
        // Creating a new linked list
        LinkedListConcept linkedList = new LinkedListConcept();

        // Adding some elements to the list
        linkedList.insertFirst(3);
        linkedList.insertFirst(5);
        linkedList.insertFirst(7);
        linkedList.insertFirst(9);

        // Displaying the linked list
        linkedList.display();
    }
}