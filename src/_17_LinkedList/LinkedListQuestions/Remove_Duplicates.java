package _17_LinkedList.LinkedListQuestions;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//83. Remove Duplicates from Sorted List

public class Remove_Duplicates {
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

        ListNode(int val, ListNode next) {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next; // Skip duplicate
            } else {
                node = node.next; // Move to the next distinct element
            }
        }
        return head;
    }

    // display
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
        Remove_Duplicates dub = new Remove_Duplicates();
        dub.insertFirst(3);
        dub.insertFirst(3);
        dub.insertFirst(2);
        dub.insertFirst(1);
        dub.insertFirst(1);

        dub.head = dub.deleteDuplicates(dub.head); // Correcting method call

        dub.display(); // Displaying the list after removing duplicates
    }
}
