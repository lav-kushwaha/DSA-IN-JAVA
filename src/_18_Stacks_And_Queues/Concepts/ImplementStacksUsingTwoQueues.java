package _18_Stacks_And_Queues.Concepts;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/implement-stack-using-queues/
//225. Implement Stack using Queues

// Define a class named ImplementStacksUsingQueues to implement a stack using two queues
class ImplementStacksUsingTwoQueues {
    Queue<Integer> que1; // First queue
    Queue<Integer> que2; // Second queue

    // Constructor to initialize the queues as linked lists
    public ImplementStacksUsingTwoQueues() {
        que1 = new LinkedList<>(); // Initialize que1 as an empty linked list
        que2 = new LinkedList<>(); // Initialize que2 as an empty linked list
    }

    // Method to push an element onto the stack
    public void push(int x) {
        que2.add(x); // Add the new element to que2

        // Move all elements from que1 to que2
        while (!que1.isEmpty()) {
            que2.add(que1.poll()); // Remove the front element of que1 and add it to que2
        }

        // Swap que1 and que2, so that que1 always contains the elements of the stack
        Queue<Integer> temp = que1; // Store que1 in a temporary variable
        que1 = que2; // Assign que2 to que1
        que2 = temp; // Assign the temporary variable to que2
    }

    // Method to pop the top element from the stack
    public int pop() {
        return que1.poll(); // Remove and return the front element of que1
    }

    // Method to get the top element of the stack without removing it
    public int top() {
        return que1.peek(); // Return the front element of que1 without removing it
    }

    // Method to check if the stack is empty
    public boolean empty() {
        return que1.isEmpty(); // Return true if que1 is empty, false otherwise
    }


    public static void main(String[] args) {
        ImplementStacksUsingTwoQueues obj = new ImplementStacksUsingTwoQueues();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop()); // Output: 2
        System.out.println(obj.top()); // Output: 1
        System.out.println(obj.empty()); // Output: false
    }
}

/*
#poll
  ->The poll method is used to remove and return the front element of the queue.
  ->It also returns null if the queue is empty, avoiding exceptions.
 */

