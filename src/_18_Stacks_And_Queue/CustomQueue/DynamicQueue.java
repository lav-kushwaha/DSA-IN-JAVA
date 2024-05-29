package _18_Stacks_And_Queue.CustomQueue;

public class DynamicQueue extends CustomQueue {

    // Default constructor
    public DynamicQueue() {
        super();//using super keyword, it will call parent constructor CustomQueue(). ctrl+click on super() to see.
    }

    // Constructor with custom size
    public DynamicQueue(int size) {
        super(size);//it will call parent constructor CustomQueue(int size)
    }

    // Insert an item to the queue
    public boolean Enqueue(int item) {
        if (isFull()) {
            //double the array size.
            int [] temp = new int[data.length*2];

            //copy all previous item in new data.
            for (int i=0;i<data.length;i++){
                temp[i] = data[(front+i) % data.length];
            }

            front = 0;
            end = data.length;
            //temp are assign to the data.
            data = temp;
        }

        return super.Enqueue(item);
    }


}
