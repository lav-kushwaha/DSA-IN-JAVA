package _17_LinkedList.LinkedListQuestions;
//https://leetcode.com/problems/merge-two-sorted-lists/description/
//21. Merge Two Sorted Lists

public class MergeTwoSortedList {
    private ListNode head;

    // Creating Node.
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // insert
    public void insertFirst(int val) {
        // Create a new node with the given value.
        ListNode newNode = new ListNode(val);
        // Set the next pointer of the new node to the current head.
        newNode.next = head;
        // Update the head to point to the new node.
        head = newNode;
    }

    public void display() {
        // Start from the head of the list.
        ListNode temp = head;

        // Traverse the list and print each element.
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        // Print "END" to mark the end of the list.
        System.out.println("END");
    }
    public static void main(String[] args) {
        MergeTwoSortedList Merge = new MergeTwoSortedList();
        Merge.display(); // Displaying the list after removing duplicates
    }
}

