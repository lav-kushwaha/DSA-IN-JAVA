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
        System.out.print("START");
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

        //insert 100 after 12
        DLL.insert(12,100);
        DLL.display();
    }
}
