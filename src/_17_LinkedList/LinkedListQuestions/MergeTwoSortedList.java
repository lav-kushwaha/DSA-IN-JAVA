package _17_LinkedList.LinkedListQuestions;
//https://leetcode.com/problems/merge-two-sorted-lists/description/
//21. Merge Two Sorted Lists


public class MergeTwoSortedList {
    private ListNode head;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if list1 and list2 will be empty
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Merge list in separate node.
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // check if any one of list is longer.
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedList merge = new MergeTwoSortedList();

        // Populate list1: 1 -> 2 -> 4
        merge.insertFirst(4);
        merge.insertFirst(2);
        merge.insertFirst(1);

        // Display list1
        System.out.println("List 1:");
        merge.display();

        // Create another instance for list2
        MergeTwoSortedList merge2 = new MergeTwoSortedList();

        // Populate list2: 1 -> 3 -> 4
        merge2.insertFirst(4);
        merge2.insertFirst(3);
        merge2.insertFirst(1);

        // Display list2
        System.out.println("List 2:");
        merge2.display();

        // Merge the two lists
        ListNode mergedList = merge.mergeTwoLists(merge.head, merge2.head);

        // Display the merged list
        System.out.println("Merged List:");
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("END");
    }
}

