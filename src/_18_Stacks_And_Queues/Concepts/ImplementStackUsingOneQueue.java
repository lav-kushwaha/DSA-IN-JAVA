package _18_Stacks_And_Queues.Concepts;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingOneQueue {
    // Queue to store stack elements
    Queue<Integer> queue;

    // Constructor to initialize the queue
    public ImplementStackUsingOneQueue() {
        queue = new LinkedList<>();
    }
    
    // Method to push an element onto the stack
    public void push(int x) {
        // Add the new element to the queue
        queue.add(x);

        // Reverse the order of elements in the queue to maintain stack order
        for(int i = 0; i < queue.size() - 1; i++) {
            // Remove the element from the front and add it to the back of the queue
            queue.add(queue.poll());
        }
    }
    
    // Method to remove and return the top element of the stack
    public int pop() {
        // Remove and return the element from the front of the queue
        return queue.poll();
    }
    
    // Method to return the top element of the stack without removing it
    public int top() {
        // Return the element at the front of the queue
        return queue.peek();
    }
    
    // Method to check if the stack is empty
    public boolean empty() {
        // Return true if the queue is empty, otherwise return false
        return queue.isEmpty();
    }

    // Main method for testing the stack implementation
    public static void main(String[] args) {
        ImplementStackUsingOneQueue stack = new ImplementStackUsingOneQueue();
        
        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Check the top element
        System.out.println("Top element: " + stack.top()); // Should print 3

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop()); // Should print 3
        System.out.println("Popped element: " + stack.pop()); // Should print 2

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.empty()); // Should print false

        // Pop the remaining element
        System.out.println("Popped element: " + stack.pop()); // Should print 1

        // Check if the stack is empty again
        System.out.println("Is stack empty? " + stack.empty()); // Should print true
    }
}

//Note : we have to convert queue that gives the output like stack, and we will used all queue method.
//FIFO(Queue) -> LIFO(Stack)
