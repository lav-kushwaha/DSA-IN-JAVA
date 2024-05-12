package _17_LinkedList.LinkedListQuestions;


class ReverseLinkedList_II {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Create a dummy node to facilitate reversal
        ListNode dummy = new ListNode(0);
        dummy.next = head; // Connect dummy to the head of the list
        ListNode prev = dummy; // Initialize prev as dummy to track the node before the sublist to be reversed

        // Move prev to the node before the sublist to be reversed
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // current will be after prev node.
        ListNode current = prev.next; // Start reversing from the node next to prev
        ListNode nextNode;

        // Reverse the sublist from left to right
        for (int i = left; i < right; i++) {
            nextNode = current.next; // Save the next node before changing pointers
            current.next = nextNode.next; // Connect current to the node after the nextNode
            nextNode.next = prev.next; // Connect nextNode to the node after prev
            prev.next = nextNode; // Connect prev to nextNode
        }

        return dummy.next; // Return the head of the modified list
    }

    public static void main(String[] args) {
        // Create the input linked list: head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Define left and right values
        int left = 2;
        int right = 4;

        // Create an instance of ReverseLinkedList_II
        ReverseLinkedList_II solution = new ReverseLinkedList_II();

        // Call the reverseBetween method
        ListNode result = solution.reverseBetween(head, left, right);

        // Print the result
        printList(result);
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
