package _17_LinkedList;

public class LinkedListConcept {
    // Every linked list has a head and tail.
    // Private because we don't want to access anyone.
    private Node head; // Head of the linked list.
    private Node tail; // Tail of the linked list.

    private int size; // Size of the linked list.

    // Node - which has a value and next node.
    // Private because we don't want to access anyone.
    private class Node {

        private int value; // Value of the node.
        private Node next; // Reference to the next node. By default, it is null

//        // Constructor with value parameter.
        public Node(int value) {
            this.value = value;
        }

        // Constructor with value and next node parameters.
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Constructor of the LinkedListConcept class.
    public LinkedListConcept() {
        // Initialize size to 0.
        this.size = 0;
    }

    // Method to add a new node at the beginning of the linked list.
    public void insertFirst(int val) {
        // Create a new node with the given value.
        Node newNode = new Node(val);
        // Set the next pointer of the new node to the current head.
        newNode.next = head;
        // Update the head to point to the new node.
        head = newNode;

        // If the list was empty, update the tail reference as well.
        //Head and tail pointing to the same node.
        if (tail == null) {
            tail = head;
        }

        // Increase the size.
        size++;
    }

    //Insert element into the last of linkedlist.
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        size++;
    }

    // Method to print all elements of the linked list.
    public void display() {
        // Start from the head of the list.
        Node temp = head;

        // Traverse the list and print each element.
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        // Print "END" to mark the end of the list.
        System.out.println("END");
    }

    // Method to print the count of elements in the linked list.
    public void printCount() {
        System.out.println("Count: " + size);
    }

    // Main method to test the LinkedListConcept class.
    public static void main(String[] args) {
        // Creating a new linked list.
        LinkedListConcept linkedList = new LinkedListConcept();
        // Adding some elements to the list
        linkedList.insertFirst(3);
        linkedList.insertFirst(5);
        linkedList.insertFirst(7);
        linkedList.insertFirst(9);

        //inserting element into the last
        linkedList.insertLast(22);

        // Displaying the linked list
        linkedList.display();

        // Print the count of elements
        linkedList.printCount();
    }
}
