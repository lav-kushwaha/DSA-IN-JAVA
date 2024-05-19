package _18_Stacks_And_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExamples {
    public static void main(String[] args) {
        //A linear collection that supports element insertion and removal at both ends.
        // The name deque is short for "double ended queue" and is usually pronounced "deck".
        Deque<Integer> deque = new ArrayDeque<>();

        // Adding elements to the front and back of the deque
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);

        // Output: [3, 1, 2, 4]
        System.out.println(deque);

        // Removing elements from the front and back of the deque
        int firstElement = deque.removeFirst();
        int lastElement = deque.removeLast();

        // Output: 3 (removed first element)
        System.out.println("Removed first element: " + firstElement);

        // Output: 4 (removed last element)
        System.out.println("Removed last element: " + lastElement);

        // Output: [1, 2]
        System.out.println(deque);

        // Peeking at the front and back of the deque
        int frontElement = deque.peekFirst();
        int backElement = deque.peekLast();

        // Output: 1 (front element)
        System.out.println("Front element: " + frontElement);

        // Output: 2 (back element)
        System.out.println("Back element: " + backElement);
    }
}
