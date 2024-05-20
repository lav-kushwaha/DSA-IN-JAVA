package _17_LinkedList.LinkedListQuestions.SlowAndFastPointerQuestions;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
//2095. Delete the Middle Node of a Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        // If the list is empty or has only one node, return null
        if (head == null || head.next == null) return null;

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Traverse the list with slow and fast pointers
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }

    // Helper method to print the list (for testing purposes)
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        DeleteMiddleNode solution = new DeleteMiddleNode();
        head = solution.deleteMiddle(head);

        System.out.println("List after deleting the middle node:");
        printList(head);
    }
}
