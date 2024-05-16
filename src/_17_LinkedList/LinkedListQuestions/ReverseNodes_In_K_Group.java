package _17_LinkedList.LinkedListQuestions;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
//25. Reverse Nodes in k-Group(Fav Question).

public class ReverseNodes_In_K_Group {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev != null) {
            prev = reverseNextK(prev, k); // tail becomes prev here.
        }

        return dummy.next;
    }

    // Reverse next k nodes starting from prev.
    // Returns the last node of the reversed list.
    private ListNode reverseNextK(ListNode prev, int k) {
        ListNode last = prev;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            if (i < k && last == null) {
                return null; // Not enough nodes to reverse, no need to proceed.
            }
        }

        ListNode tail = prev.next; // First node of the group before reversing.
        ListNode curr = prev.next.next; // Second node of the group before reversing.
        ListNode next;
        while (curr != last) {
            next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next;
        }

        return tail; // Returning tail as the new prev for the next iteration.
    }

    // Helper function to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseNodes_In_K_Group solution = new ReverseNodes_In_K_Group();

        System.out.println("Original Linked List:");
        printList(head);

        int k = 2; // Group size
        ListNode reversedHead = solution.reverseKGroup(head, k);

        System.out.println("Linked List after reversing every " + k + " elements:");
        printList(reversedHead);
    }
}
