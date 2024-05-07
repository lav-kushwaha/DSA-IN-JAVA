package _17_LinkedList.LinkedListQuestions.SlowAndFastPointerQuestions;

//https://leetcode.com/problems/linked-list-cycle-ii/
//142. Linked List Cycle II

public class LinkedListCycle_II {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to detect the start of a cycle in a linked list.
    public static ListNode detectCycle(ListNode head) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; //creating a cycle.

        ListNode ans = detectCycle(head);
        System.out.println(ans.val); //cycle node start from node 2

    }
}
