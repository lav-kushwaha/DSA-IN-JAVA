package _17_LinkedList.LinkedListQuestions.SlowAndFastPointerQuestions;

//https://leetcode.com/problems/middle-of-the-linked-list/
//876. Middle of the Linked List

public class MiddleOfTheLinkedList {

   static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //1st Method - slow and fast pointer
    public ListNode middleNode(ListNode head) {
        if(head ==null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //2nd method,find the length and then half the length and traverse.
    public ListNode middleNodes(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        int size = 0;

        if(head == null) return null;

        while(node!=null){
            node = node.next;
            size++;
        }

        int mid = size/2;

        ListNode temp = head;

        while(mid!=0){
            temp = temp.next;
            mid--;
        }

        return temp;
    }

    public static void main(String[] args) {
        // Example usage:
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();
        ListNode middle = solution.middleNode(head);

        if (middle != null) {
            System.out.println("Middle node value: " + middle.val);
        } else {
            System.out.println("List is empty.");
        }
    }
}

