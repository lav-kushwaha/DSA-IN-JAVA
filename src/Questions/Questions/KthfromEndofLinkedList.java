package Questions.Questions;

class KthfromEndofLinkedList
 {

    int getKthFromLast(Node head, int k) {
        // Your code here
        if(head==null) return -1;
        
        int size = 0;
        Node curr = head;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        
        if(size<k) return -1;
        
        Node ans = head;
        for(int i=0;i<size-k;i++){
            ans = ans.next;
        }
        
        return ans.data;
        
    }
}