package Questions.SEP;
import java.util.HashSet;

//https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
//3217. Delete Nodes From Linked List Present in Array

public class DeleteNodeFromLLPresentInArray {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public ListNode removeNodes(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteNodeFromLLPresentInArray solution = new DeleteNodeFromLLPresentInArray();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int[] nums1 = {1, 2, 3};
        ListNode result1 = solution.removeNodes(head1, nums1);
        solution.printList(result1);
    }
}
