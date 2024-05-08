package _17_LinkedList.LinkedListQuestions;

//https://leetcode.com/problems/sort-list/
//148. Sort List

class MergeSort {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    //Merge-Sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1: Divide the linked list into two halves
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        if (prev != null) {
            prev.next = null; // Disconnect the first half
        }

        // Recursively sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Step 2: Merge the sorted halves
        return merge(left, right);
    }

    // Helper function to merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Connect the remaining nodes of either list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void display(ListNode head) {
        if (head == null) {
            System.out.println("Head is null");
            return;
        }
        ListNode node = head;

        while (node != null) {
            System.out.print(node.val + " => ");
            node = node.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);

        // Connecting nodes
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        MergeSort sort = new MergeSort();
        ListNode sortedHead = sort.sortList(head);

        // Printing sorted list
        display(sortedHead);
    }
}
