package _19_Binary_Trees;

public class SegmentTree {
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    //root node
    private Node root;

    public SegmentTree(int[] arr){
        //create a tree using this array
        this.root = constructTree(arr,0,arr.length-1);
    }

    //construct tree.
    private Node constructTree(int[] arr, int start, int end) {
        if(start == end){ //base condtion leaf node.
            //leaf node
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }

        //create new node with index you are at.
        Node node = new Node(start,end);

        int mid = (start+end)/2;

        node.left = this.constructTree(arr,start,mid);
        node.right = this.constructTree(arr,mid+1,end);


        node.data = node.left.data + node.right.data;

        return node; //this node will return after addition from where that function is called.
    }


    //display Method
    public void display(){
        display(this.root);
    }

    private void display(Node node){
        String str = "";

        if(node.left!=null){
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.startInterval+ "] and data: "+node.left.data+" => ";
        }else{
            str = str + "No left child";
        }

        //for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.left.startInterval + "] and data: "+node.data+ " <=";

        if(node.right!=null){
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.startInterval+ "] and data: "+node.right.data+" => ";
        }else{
            str = str + "No right child";
        }

        System.out.println(str);

        //call recursion
        if(node.left!=null){
            display(node.left);
        }

        if(node.right!=null){
            display(node.right);
        }
    }

    public static void main(String [] args){
        int[] arr = {3,8,6,7,-2,-8,4,9};

        SegmentTree tree = new SegmentTree(arr);

   }
}
