package _17_LinkedList;


public class Main {
    public static void main(String[] args) {
        //Generics Linked-list provided by java to us.
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(12);
//        System.out.println(list);//[12]


        // Create a new singly linked list
        SinglyLinkedListConcept list = new SinglyLinkedListConcept();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);

        //display the element
        list.display();

    }
}
