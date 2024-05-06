package _17_LinkedList.LinkedListQuestions.CycleDetectionQuestions;

//https://leetcode.com/problems/linked-list-cycle-ii/
//142. Linked List Cycle II

public class LinkedListCycle_II {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to detect the start of a cycle in a linked list.
    public ListNode detectCycle(ListNode head) {
        // If head is null, there's no cycle.
        if (head == null) return null;

        // Initialize slow and fast pointers.
        ListNode slow = head;
        ListNode fast = head;

        // Move slow and fast pointers until they meet.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at the same node, there's a cycle.
            if (slow == fast) {
                // Find the start of the cycle node.

                // Reset slow to head.
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Return the start of the cycle node.
            }
        }
        return null; // No cycle found.
    }
}
