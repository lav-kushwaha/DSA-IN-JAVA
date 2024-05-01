package _17_LinkedList;

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
        Node last = null;
        while(node!=null){
            System.out.print(node.val+" => ");

            //In the end this node will goes till last node and assign last node ref to "last".
            last = node;
            node = node.next;
        }
        System.out.println("END");

        while (last!=null){
            System.out.print(last.val+" <= ");
            last = last.prev;
        }
        System.out.print("START");
    }

    public static void main(String[] args) {
        DoublyLinkedListConcept DLL = new DoublyLinkedListConcept();
        DLL.insertFirst(12);
        DLL.insertFirst(23);
        DLL.insertFirst(2);
        DLL.insertFirst(32);
        DLL.insertFirst(57);
        DLL.display();
    }
}
