package _17_LinkedList.LinkedListQuestions.CycleDetectionQuestions;

//https://leetcode.com/problems/linked-list-cycle/description/
//141.Linked List Cycle.

//Slow and fast pointer.
//Floyd’s Cycle Algorithm or Tortoise And Hare algorithm.

public class LinkedListCycleDetectionConcepts {

    // Definition for singly-linked list.
     static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //check in the list there is cycle or not.
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


    //count the length of the cycle.
    public int lengthCycle(ListNode head) {

        // If head is null, there can't be a cycle.
        if (head == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        int size = 0; // Initialize size

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at the same node, there's a cycle.
            if (slow == fast) {
                // calculate the length.
                do {
                    slow = slow.next;
                    size++;
                } while (slow != fast);
                return size;
            }
        }
        return 0; // No cycle found
    }

    public static void main(String[] args) {

        // Example usage
        ListNode head =  new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Creating a cycle

        LinkedListCycleDetectionConcepts solution = new LinkedListCycleDetectionConcepts(); // corrected the object creation
        System.out.println(solution.hasCycle(head)); // Output: true

        //count the length of the cycle.
        System.out.println(solution.lengthCycle(head));
    }
}
