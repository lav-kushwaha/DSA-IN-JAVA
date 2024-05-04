package _17_LinkedList;

public class SinglyLinkedListConcept {
    // Every linked list has a head and tail.
    // Private because we don't want to access anyone.
   // head: This would be null, indicating that there are no elements in the list yet.
    private Node head; // Head of the linked list.

    //Benefit of taking this extra variable is we can add element from the last.
    //tail: This would also be null, as there are no elements in the list to have a tail.
    private Node tail; // Tail of the linked list.

    private int size; // Size of the linked list.

    // Node - which has a value and next node.
    // Private because we don't want to access anyone.
    private class Node {

        private int value; // Value of the node.

        // Reference to the next node.
        //next would typically be null, indicating that there is no next node.
        private Node next;

        // Constructor with value parameter.
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
    public SinglyLinkedListConcept() {
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

    //Insert element at any index.
    public void insert (int val,int index){

            //if index is 0 insert element at the 0 index
            if(index==0){
                insertFirst(val);
                return;
            }

            //if index is last(size) then insert element into the last.
            if (index==size){
                insertLast(val);
                return;
            }

            Node temp = head;
            for(int i=1;i<index;i++){
               temp = temp.next;
            }

            Node node = new Node(val, temp.next); //100,8
            temp.next = node; //100,8

            size++;
    }

    //Delete First Element from LL.
    public int DeleteFirst(){
        int val = head.value;
        head = head.next;

        if (head==null){
            //if head is null, then tail should also be null.
            tail = tail.next;
        }

        size--;

        //return the value which is deleted.
        return val;
    }

    //Delete Last Element from LL.
    public int DeleteLast(){
        if(size<=1){
            return DeleteFirst();
        }

        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    //Delete a particuar index.
    public int delete(int index){
        //delete first
        if(index==0){
            return DeleteFirst();
        }

        //delete last
        if(index== size-1){
            return DeleteLast();
        }

        //Jo bhi node delete karna hai usse ek previous node pe chala ja.
        Node prev = get(index-1);
        int val = prev.next.value;

        //yaha pe delete node se ek pehle node ke baad delete hone wala node ke baad chala ja.
        prev.next = prev.next.next;
        return val;
    }

    //find the particular element.
    //complexity is o(n) where n is the total no. of node.
    public Node find(int value){
        //node start from head.
        Node node = head;
        while (node!=null){
            if(node.value == value){
                return node;
            }
            //if node.value is not equal to value move forward.
            node = node.next;
        }
        //if not found element return null.
        return null;
    }

    public Node get(int index){
        //node start from head.
        Node node = head;
        for(int i=0;i<index;i++){
            node = node.next;
        }

        //it will return reference pointer to that node.
        return node;
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

    //insert element using recursion
    public void insertRecursion(int val, int index){
        head = insertRec(val,index,head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

        node.next = insertRec(val,index-1,node.next);
        return node;
    }

    // Main method to test the LinkedListConcept class.
    public static void main(String[] args) {
        // Creating a new linked list.
        SinglyLinkedListConcept linkedList = new SinglyLinkedListConcept();
        // Adding some elements to the list
        linkedList.insertFirst(18);
        linkedList.insertFirst(12);
        linkedList.insertFirst(8);
        linkedList.insertFirst(9);
        linkedList.insertFirst(5);
        linkedList.insertFirst(3);

        //inserting element from the last
//        linkedList.insertLast(22);

        //Inserting element at any index;
//        linkedList.insert(100,3);


        // Displaying the linked list
//        linkedList.display();

        // Delete first element from the linked list.
//        System.out.println(linkedList.DeleteFirst());

        //Delete element from last.
//        System.out.println(linkedList.DeleteLast());

        //Delete any particular node.
//        System.out.println(linkedList.delete(4));

        //find the particular element
//        System.out.println(linkedList.find(5));

        // Displaying the linked list
        linkedList.display();

        // Print the count of elements
//        linkedList.printCount();


        //insert element using recursion
        linkedList.insertRecursion(6,2);

        // Displaying the linked list
        linkedList.display();

    }
}
