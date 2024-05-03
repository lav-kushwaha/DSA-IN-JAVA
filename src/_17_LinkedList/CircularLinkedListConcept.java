package _17_LinkedList;

public class CircularLinkedListConcept {

    private Node head;
    private Node tail;

    CircularLinkedListConcept() {
        this.head = null;
        this.tail = null;
    }

    class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Insert
    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head; // Circular connection
            return;
        }

        tail.next = node;
        node.next = head; // circular connection
        tail = node;
    }

    //Delete element.
    public void deleteElement(int val){
        Node node = head;

        //if head value we want to delete.
        if(node.val==val){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.val == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node!=head);

    }

    // Delete element by using index.
    public void delete(int index) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (index == 0) {
            if (head == tail) { // if there's only one element
                head = null;
                tail = null;
            } else {
                tail.next = head.next;
                head = head.next;
            }
            return;
        }

        Node prev = get(index - 1);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    // Get node at index
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Display
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

        //While-Loop, will not work bcz node is equal to head and condition will become false,
        //that's why we have used, do while loop - in do while loop first it will print value,
        //and node will be move forward, i.e, node = node.next
//        while (node != head){
//            System.out.print(node.val + " => ");
//            node = node.next;
//        }
//        System.out.println("Head");
    }

    public static void main(String[] args) {
        CircularLinkedListConcept cll = new CircularLinkedListConcept();
        cll.insert(12);
        cll.insert(13);
        cll.insert(14);
        cll.display(); // Output: 12 => 13 => 14 =>

//        cll.delete(1); // Delete element at index 1
//        cll.display(); // Output: 12 => 14 =>
//
//        cll.deleteElement(14); // Delete element 14
//        cll.display(); // Output: 12 =>
    }
}
