package _17_LinkedList.LinkedListQuestions.CycleDetectionQuestions;

//https://leetcode.com/problems/linked-list-cycle/description/
//141. Linked List Cycle

public class LinkedListCycle {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if there are less than two nodes
        }

        ListNode slow = head;
        ListNode fast = head; // Both start at head

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps

            if (slow == fast) {
                return true; // If slow and fast meet, it means there's a cycle
            }
        }

        return false; // If fast or its next is null, it means end of the list reached, so no cycle
    }

    public static void main(String[] args) {

        // Example usage
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Creating a cycle

        LinkedListCycle solution = new LinkedListCycle(); // corrected the object creation
        System.out.println(solution.hasCycle(head)); // Output: true
    }
}
