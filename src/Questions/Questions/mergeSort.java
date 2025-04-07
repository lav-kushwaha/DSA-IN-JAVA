package Questions.Questions;


//Merge Sort for Linked List
//https://www.geeksforgeeks.org/problems/sort-a-linked-list/0
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
class mergeSort
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        
       if (head == null || head.next == null) return head;
            
        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
         if (prev != null) {
            prev.next = null; // Disconnect the first half
        }
        
        Node first = mergeSort(head);
        Node second = mergeSort(slow);
        
        return merge(first, second);
        
    }
    
       static Node merge(Node first, Node second){
        
        Node dummy = new Node(-1);
        Node current = dummy;
        
        while(first!=null && second!=null){
            if(first.data < second.data){
                current.next = first;
                first = first.next;
            }else{
                current.next = second;
                second = second.next;
            }
            
            current = current.next;
        }
        
        
        if(first!=null){
            current.next = first;
        }else{
            current.next = second;
        }
        
        return dummy.next;
        
    }

    
}