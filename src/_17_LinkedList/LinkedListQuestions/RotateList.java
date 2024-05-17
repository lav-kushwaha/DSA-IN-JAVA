package _17_LinkedList.LinkedListQuestions;

//https://leetcode.com/problems/rotate-list/description/
//61. Rotate List

class RotateList {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (k <= 0 || head == null || head.next == null) return head;

    ListNode last = head;
    int length = 1;
    while (last.next != null) {
      last = last.next;
      length++;
    }

    last.next = head;
    int rotations = k % length; //2%5 is remainder 2.
    int skip = length - rotations; // 5-2 =3
    ListNode newLast = head;
    for (int i = 0; i < skip - 1; i++) { // 0,1  bcz skip-1 = 3 -1 = 2 and i<2.
      newLast = newLast.next; //it will reach 2nd node.
    }

    head = newLast.next;
    newLast.next = null;

    return head;
  }

  public static void main(String[] args) {
    RotateList solution = new RotateList();

    int[] values = {1, 2, 3, 4, 5};
    ListNode head = createLinkedList(values);
    int k = 2;

    System.out.print("Original list: ");
    printLinkedList(head);

    ListNode rotatedHead = solution.rotateRight(head, k);

    System.out.print("Rotated list: ");
    printLinkedList(rotatedHead);
  }

  private static ListNode createLinkedList(int[] values) {
    if (values.length == 0) return null;
    ListNode head = new ListNode(values[0]);
    ListNode current = head;
    for (int i = 1; i < values.length; i++) {
      current.next = new ListNode(values[i]);
      current = current.next;
    }
    return head;
  }

  private static void printLinkedList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }
}
