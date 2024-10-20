package Questions.SEP;

//2807. Insert Greatest Common Divisors in Linked List
//https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/

class insertGreatestCommonDivisorsInLL {
    static class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        while (curr.next != null) {
            int gcd = findGcd(curr.val, curr.next.val);
            ListNode gcdNode = new ListNode(gcd);
            gcdNode.next = curr.next;
            curr.next = gcdNode;
            curr = curr.next.next;
        }
        return head;
    }

    public int findGcd(int a, int b) {
        if (b == 0) return a; 
        return findGcd(b, a % b);
    }

    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    
    public ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        insertGreatestCommonDivisorsInLL solution = new insertGreatestCommonDivisorsInLL();
        
        int[] values = {18, 24, 30, 40, 60};
        ListNode head = solution.createLinkedList(values);
        
        // Print original list
        System.out.println("Original list:");
        solution.printList(head);
        
        // Insert GCD nodes and print modified list
        head = solution.insertGreatestCommonDivisors(head);
        System.out.println("Modified list with GCDs inserted:");
        solution.printList(head);
    }
}