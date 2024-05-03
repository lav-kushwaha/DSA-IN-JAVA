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
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head; // Circular connection
            return;
        }

        tail.next = node;
        node.next = head; //circular connection
        tail = node;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node node = head;
        do {
            System.out.print(node.val + " => ");
            node = node.next;
        } while (node != head);
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