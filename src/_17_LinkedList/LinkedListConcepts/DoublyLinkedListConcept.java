package _17_LinkedList.LinkedListConcepts;

public class DoublyLinkedListConcept {

    private Node head;

    //Creating node for doubly linked list.
    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        //why this condition bcs suppose, if there is no node then by default head is null
        //and null.prev = null gives error that's why.
        if(head!=null){
           head.prev = node;
       }
        //Here, head is equal to node.
        head = node;
    }

    public void display(){
        //we have taken extra node bcs we don't want to change the structure of LL.
        //we have taken node to traverse the dll.
        Node node = head;

        //This extra variable for reverse dll.
        Node last = null;
        while(node!=null){
            System.out.print(node.val+" => ");

            //In the end this node will goes till end node and assign end node reference to last variable.
            last = node;
            node = node.next;
        }
        System.out.println("END");


        System.out.println("Print in reverse");
        while (last!=null){
            System.out.print(last.val+" <= ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;

        //If head is null
        if(head==null){
            node.prev = null;
            head = node;
            return;
        }

        while(last.next!=null){
            last = last.next;
        }

        node.prev = last;
        node.next = null;
        last.next = node;

    }
    //Insert element after element
    public void insert(int after, int val){
        Node p = find(after);
        if(p==null){
            System.out.println("Does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next!=null){
            //otherwise it will throw null.prev = p is error.
            node.next.prev = node;
        }
    }

    public int delete(int valToDelete) {
        // Find the node to delete
        Node nodeToDelete = find(valToDelete);

        // If nodeToDelete is null, the element doesn't exist in the list
        if (nodeToDelete == null) {
            System.out.println("Element does not exist in the list");
            return -1; // Return some default value indicating failure
        }

        // If the node to delete is the head
        if (nodeToDelete == head) {
            head = nodeToDelete.next; // Move head to the next node
        }

        // Adjusting pointers for the previous node
        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        }

        // Adjusting pointers for the next node
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        }

        return nodeToDelete.val; // Return the value of the deleted node
    }


    public Node find(int value){
        //node start from head.
        Node node = head;
        while (node!=null){
            if(node.val == value){
                return node;
            }
            //if node.value is not equal to value move forward.
            node = node.next;
        }
        //if not found element return null.
        return null;
    }

    public static void main(String[] args) {
        DoublyLinkedListConcept DLL = new DoublyLinkedListConcept();
        DLL.insertFirst(12);
        DLL.insertFirst(23);
        DLL.insertFirst(2);
        DLL.insertFirst(32);
        DLL.insertFirst(57);
        DLL.display();


        System.out.println(DLL.delete(2));

        //insert 100 after 12
        DLL.insert(2,100);
        DLL.display();
    }
}
