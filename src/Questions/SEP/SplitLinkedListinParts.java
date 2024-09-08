package Questions.SEP;

//https://leetcode.com/problems/split-linked-list-in-parts/?envType=daily-question&envId=2024-09-08
//725. Split Linked List in Parts

class SplitLinkedListinParts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode[] res = new ListNode[k];
        temp = head;
        int avg = size / k;
        int extra = size % k;
        for(int i = 0; i < k; i++) {
            if(temp == null) break;
            ListNode currHead = temp;
            ListNode prev = null;
            int len = 0;

            while(temp != null && len < avg) {
                prev = temp;
                temp = temp.next;
                len++;
            }

            if(extra > 0) {
                prev = temp;
                temp = temp.next;
                extra--;
            }

            if (prev != null) {
                prev.next = null;
            }

            res[i] = currHead;
        }

        return res;
    }

    public void printListParts(ListNode[] parts) {
        for (int i = 0; i < parts.length; i++) {
            System.out.print("Part " + (i + 1) + ": ");
            ListNode temp = parts[i];
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        int k = 3;

        SplitLinkedListinParts solution = new SplitLinkedListinParts();
        ListNode[] result = solution.splitListToParts(head, k);
        solution.printListParts(result);
    }
}
