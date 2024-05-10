package _17_LinkedList.LinkedListQuestions;

public class BubbleSort {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public BubbleSort() {
        this.size = 0;
    }

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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    second.next = first;
                    first.next = null;
                    tail = first;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        BubbleSort list = new BubbleSort();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(9);
        list.insertFirst(14);

        System.out.println("Original List:");
        list.display();

        list.bubbleSort();

        System.out.println("Sorted List:");
        list.display();
    }
}
