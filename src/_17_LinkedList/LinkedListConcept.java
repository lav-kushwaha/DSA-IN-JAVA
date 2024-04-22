package _17_LinkedList;



public class LinkedListConcept {

    //every linked-list has a head and tail.
    //private bcs we don't want to access anyone.
    private Node head; // Head of the linked list.
    private Node tail; // Tail of the linked list.

    private int size;

    //constructor
     public LinkedListConcept(){
        this.size = 0;
    }


   // Method to add a new node at the beginning of the linked list
    public void insertFirst(int val){
         //inserting new node
         Node Newnode = new Node(val);
         //NewNode pointing to the next node but the problem is now head position is 2nd.
         Newnode.next = head;
         //Here head comes to the first position.
         head = Newnode;

         if(tail==null){
             tail = head;
         }

         //increase the size.
         size+=1;

    }

    // Method to print all elements of the linked list
    public void display(){
         Node temp = head;

         while(temp!=null){
             System.out.print(temp.value+ " -> ");
             temp = temp.next;
         }
        System.out.println("END");
    }

    //Node - which has a value and next node.
    //private bcs we don't want to access anyone.
    private class Node{

       private int value; //by default node value is null.
       private Node next; //by default node value is null.

       //constructor
       public Node(int value){
           this.value = value;
       }

        //constructor
        public Node(int value, Node next){
           this.value = value;
           this.next = next;
       }


    }

    public static void main(String[] args) {

    }



}
