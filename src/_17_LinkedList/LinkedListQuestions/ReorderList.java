package _17_LinkedList.LinkedListQuestions;



class ReorderList {

   static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        //find mid element.
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half of the linked list.
        ListNode current = slow; //mid
        ListNode prev = null;
        ListNode next;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Merge the two halves.
        ListNode first = head;
        ListNode second = prev;
        ListNode temp;

        while (second.next != null) {
            //first halves
            temp = first.next;
            //connecting with second
            first.next = second;
            first = temp;

            //second halves
            temp = second.next;
            //connecting with first
            second.next = first;
            second = temp;
        }
    }

    public void displayList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();

        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        reorderList.displayList(head);

        reorderList.reorderList(head);

        System.out.println("Reordered Linked List:");
        reorderList.displayList(head);
    }
}
