package _17_LinkedList.LinkedListQuestions;

//https://leetcode.com/problems/reverse-linked-list/solutions/
//206. Reverse Linked List

class ReverseLinkedList {

    private ListNode head;
    private ListNode tail;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // display
    public void display() {
        // Start from the head of the list.
        ListNode temp = head;

        // Traverse the list and print each element.
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        // Print "END" to mark the end of the list.
        System.out.println("END");
    }

    // Recursion reverse
    public void reverseList(ListNode node) {
        if (node.next == null) { // Termination condition: When the next node is null
            head = node;
            tail = node;
            return;
        }

        //recursive call.
        reverseList(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //In place reverse linked list.
    //Use three pointers
    public void reverse() {
        //K.k solution.
//        ListNode prev = null;
//        ListNode current = head;
//        ListNode next = current.next;
//
//        while(current!=null){
//            current.next = prev;
//            prev = current;
//            current = next;
//
//            if(next!=null){
//                next = next.next;
//            }
//        }
//        //In the end prev will came to end node.
//        head = prev;

        //Another way.(Best)
        //Use three pointers and so you can change the next of the mid to the first one
        // without losing the track of the original left.
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move pointers one position ahead
            current = next;
        }
        head = prev; // New head of the reversed list

        //Another way.(Best)
//        ListNode prev = null;
//        ListNode current = head;
//
//        while(current != null) {
//            ListNode next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//
//        head = prev;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        // Connecting list
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReverseLinkedList list = new ReverseLinkedList();

        // Assign the head of the linked list to the instance variable 'head'
        list.head = head;
        list.tail = node4; // Initialize the tail


        // Printing the list before reversing.
         list.display();


//        list.reverseList(head);

        list.reverse();

        // Printing the list after reversing.
        list.display();
    }
}
