package _18_Stacks_And_Queue.CircularQueue;


public class CircularQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int front = 0;
    private int end = 0;
    private int size = 0;

    // Default constructor
    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    // Constructor with custom size
    public CircularQueue(int size) {
        this.data = new int[size];
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == data.length; //here, we have not taken end bcz end will may come to zero index,so take size.
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert an item to the queue
    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }

        data[end++] = item; //Insert element and then increment by 1.

        // Forming the circular loop: if end reaches the length of the data array, reset it to 0
        //if end and data.length will be same then it will make circular queue end will go to zeroth index.
        //ex - end = 5%5 = 0th
        end = end % data.length;

        //size of the array.
        size++;
        return true;
    }

    // Remove an item from the queue
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }

        //Remove the item at the front position and then increment front
        int removed = data[front++];

        // Forming the circular loop: if end reaches the length of the data array, reset it to 0
        front = front % data.length;

        //Here, we have decreases size of the queue bcz if you don't decrease size and when size is equal to data.length it will throw queue is full.
        //so, whenever we remove element we will decrease the size. so, that we can insert new element.
        //Decrement the size of the queue.
        size--;
        return removed;
    }

    // Get the front item of the queue
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];// Return the item at the front position without removing it
    }

    // Display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        int count = size;
        while (count > 0) {
            System.out.print(data[i] + " <- ");
            i = (i + 1) % data.length;// Move to the next position in circular manner
            count--;
        }
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5); // Instantiate the CircularQueue with size 5

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        queue.display(); // Should display the elements in the queue

        System.out.println(queue.remove() + " removed from queue");
        queue.display(); // Should display the remaining elements

        System.out.println("Front item is " + queue.front());
        queue.display();
    }
}
