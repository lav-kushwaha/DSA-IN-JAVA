package Questions.Questions;

class CountNode {
    class Node{
        int data;
        Node next;
        Node(int a){  data = a; next = null; }
    }
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // code here
        Node node = head;
        int count = 0;
        while(node!=null){
            count++;
            node =node.next;
        }
        return count;
    }
}