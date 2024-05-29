package _18_Stacks_And_Queue.CustomQueue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);
        queue.Enqueue(40);
        queue.Enqueue(50);

        queue.display(); // Should display the elements in the queue

        System.out.println(queue.Dequeue() + " removed from queue");
        queue.display(); // Should display the remaining elements

        System.out.println("Front item is " + queue.front());
        queue.display();

    }
}
