package _17_LinkedList.LinkedListQuestions;

//https://leetcode.com/problems/palindrome-linked-list/
//234. Palindrome Linked List

public class Palindrome {
   static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        // Find the midpoint of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode prev = null;
        ListNode current = slow; // mid
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare values of nodes from both halves
        ListNode first = head; // first half
        ListNode second = prev; // second half

        while (second != null) {
            if (first.val != second.val) {
                return false; // Mismatch found, not a palindrome
            }
            first = first.next;
            second = second.next;
        }

        return true; // No mismatches found, it's a palindrome
    }

    public static void main(String[] args) {
        // Example input: 1 -> 2 -> 2 -> 1 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Palindrome palindrome = new Palindrome();
        boolean isPalin = palindrome.isPalindrome(head);

        if (isPalin) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
