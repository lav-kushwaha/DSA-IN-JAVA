package _18_Stacks_And_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InBuiltQueueExamples {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Peek at the front element
        System.out.println(queue.peek());  // Output: 1

        // The front element is still there after peek
        System.out.println(queue.poll());  // Output: 1
        System.out.println(queue.poll());  // Output: 2
        System.out.println(queue.poll());  // Output: 3


        //it will returns null if this queue is empty.
        System.out.println(queue.poll());  // Output: null


//        System.out.println(queue.remove()); // it will throw an exception if this queue is empty.

        // Peek on an empty queue returns null
//        System.out.println(queue.peek());  // Output: null


        //example 2
//        Queue<Integer> queue1 = new LinkedList<>();
//
//        // Add elements to the queue
//        queue1.offer(1);
//        queue1.offer(2);
//        queue1.offer(3);
//
//        // Peek at the front element
//        Integer front = queue1.peek();
//        if (front != null) {
//            System.out.println("Front element is: " + front);  // Output: 1
//        } else {
//            System.out.println("Queue is empty.");
//        }
//
//        // The front element is still there after peek
//        System.out.println(queue1.poll());   // Output: 1
//        System.out.println(queue1.poll());   // Output: 2
//        System.out.println(queue1.poll());   // Output: 3
//
//        // Peek on an empty queue
//        front = queue1.peek();
//        if (front != null) {
//            System.out.println("Front element is: " + front);
//        } else {
//            System.out.println("Queue is empty.");  // Output: Queue is empty.
//        }
    }
}


//Note : In example 2
/*
  #offer
  ->The offer method is used to add elements to the queue.
  ->It is similar to add, but offer does not throw an exception if the queue is full (in bounded queues), making it safer for use in such scenarios.

  #peek
  ->The peek method is used to view the front element without removing it.
  ->It returns null if the queue is empty.

  #poll
  ->The poll method is used to remove and return the front element of the queue.
  ->It also returns null if the queue is empty, avoiding exceptions.


 */
