package _18_Stacks_And_Queue.CustomQueue;

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
        return size == data.length;
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
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    // Remove an item from the queue
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    // Get the front item of the queue
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];
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
            i = (i + 1) % data.length;
            count--;
        }
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

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
