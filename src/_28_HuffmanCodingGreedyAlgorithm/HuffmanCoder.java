package _28_HuffmanCodingGreedyAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoder {
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;//frequency
        Node left;
        Node right;

        public Node(Character data,int cost){
             this.data = data;
             this.cost = cost;
             this.left = null;
             this.right = null;
        }

        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }

    public void HuffmanEncoder(String feeder) throws Exception{
        //converting char to byte.
        HashMap<Character,Integer> fmap = new HashMap<>();

         for(int i=0;i<feeder.length();i++){
             char ch = feeder.charAt(i);
             if(fmap.containsKey(ch)){
                int ov = fmap.get(ch);//original value = ov
                ov+=1;
                fmap.put(ch,ov);
             }else{
                 fmap.put(ch,1);
             }
         }

        //creating a min-heap.
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
         //give me all the set.
        //set of the entries in the map.
        Set<Map.Entry<Character,Integer>> entrySet = fmap.entrySet();

        //iterate the entries
        for(Map.Entry<Character,Integer> entry : entrySet){
            Node node = new Node(entry.getKey(),entry.getValue());
            //after creating the node we have to insert in the minHeap
            minHeap.offer(node);
        }

        //remove and combine while the heap size remain one.
        while(minHeap.size()!=1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            //combining
            Node newNode = new Node('\0',first.cost+second.cost);
            newNode.left = first;
            newNode.right = second;

            //inserting again
            minHeap.offer(newNode);
        }

        //full-tree
        Node ft = minHeap.remove();

        //forming encoder
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        //initially in encoder pass empty string.
        this.initEncoderDecoder(ft,"");

    }

}
