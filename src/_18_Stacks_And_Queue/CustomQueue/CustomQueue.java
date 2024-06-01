package _18_Stacks_And_Queue.CustomQueue;

//Implemented Custom CustomQueue Using array.
public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int front = 0;
    protected int end = 0;

    // Default constructor
    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    // Constructor with custom size
    public CustomQueue(int size) {
        this.data = new int[size];
    }

    // Check if the queue is full
    public boolean isFull() {
        return end == data.length;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return end == 0;
    }

    // Insert an item to the queue
    public boolean Enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        data[end++] = item; // Insert item and then increment end.
        return true;
    }

    // Remove an item from the queue
    public int Dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[front];

        // Shift the elements to the left
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--; // Decrement end after removal
        return removed; // Return the removed item
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
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}

/*
#Notes.
The current implementation uses an array and shifts elements to the left on each removal, which has a time complexity of𝑂(𝑛)
For more efficient operations, consider implementing a circular queue.
If you need to track both the front and rear indices, the implementation can be extended to handle circular array logic, avoiding the need to shift elements on every dequeue operation.
*/

/*
Q:What is dequeue and enqueue?
Enqueue: Adds an item from the back of the queue.
Dequeue: Removes an item from the front of the queue.
Front/Peek: Returns the value of the item in front of the queue without dequeuing (removing) the item.
IsEmpty: Checks if the queue is empty. IsFull: Checks if the queue is full.
* */