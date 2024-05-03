package _17_LinkedList;

import java.util.SortedMap;

public class CircularLinkedListConcept {

    private Node head;
    private Node tail;

    class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular connection
        } else {
            tail.next = newNode; // Connect new node to the end
            tail = newNode; // Update tail to the new node
            tail.next = head; // Circular connection
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.val + " => ");
            current = current.next;
        } while (current != head);
        System.out.println("Head");
    }

    public static void main(String[] args) {
        CircularLinkedListConcept cll = new CircularLinkedListConcept();
        cll.insert(12);
        cll.insert(13);
        cll.insert(14);
        cll.display(); // Output: 12 => 13 => 14 =>
    }
}