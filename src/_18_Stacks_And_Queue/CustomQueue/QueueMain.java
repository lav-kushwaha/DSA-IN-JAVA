package _18_Stacks_And_Queue.CustomQueue;

public class QueueMain {
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
