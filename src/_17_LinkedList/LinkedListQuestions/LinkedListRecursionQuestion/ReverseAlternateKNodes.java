package _17_LinkedList.LinkedListQuestions.LinkedListRecursionQuestion;

//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
//Reverse alternate K nodes in a Singly Linked List.

public class ReverseAlternateKNodes {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode kAltReverse(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        int count = 0;

        /* 1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* 2) Now head points to the kth node. So change next
        of head to (k+1)th node*/
        if (head != null) {
            head.next = current;
        }

        /* 3) We do not want to reverse next k nodes. So move the current
        pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        /* 4) Recursively call for the list starting from current->next.
        And make rest of the list as next of first node */
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }

        /* 5) prev is new head of the input list */
        return prev;
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
        ReverseAlternateKNodes list = new ReverseAlternateKNodes();

        ListNode head = null;

        // Creating the linked list
        for (int i = 10; i > 0; i--) {
            head = list.push(i, head);
        }
        System.out.println("Given Linked List :");
        printList(head);
        head = list.kAltReverse(head, 3);
        System.out.println("Modified Linked List :");
        printList(head);

    }

    // Function to insert a new node at the beginning of the linked list
    public ListNode push(int newdata, ListNode head) {
        ListNode newNode = new ListNode(newdata);
        newNode.next = head;
        head = newNode;
        return head;
    }
}
