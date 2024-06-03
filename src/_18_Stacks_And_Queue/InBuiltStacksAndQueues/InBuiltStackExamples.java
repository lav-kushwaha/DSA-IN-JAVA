package _18_Stacks_And_Queue.InBuiltStacksAndQueues;

import java.util.Stack;

public class InBuiltStackExamples {
    public static void main(String[] args) {
        //Example 1: stack example
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop elements from the stack
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.pop());  // Output: 1

        // Uncommenting the following line would throw EmptyStackException
        // System.out.println(stack.pop());


        //Example 2 : using try and catch for exceptional handling.
//        Stack<Integer> stack2 = new Stack<>();
//
//        // Push elements onto the stack.
//        stack2.push(1);
//        stack2.push(2);
//        stack2.push(3);
//
//        try {
//            // Pop elements from the stack
//            System.out.println(stack2.pop());  // Output: 3
//            System.out.println(stack2.pop());  // Output: 2
//            System.out.println(stack2.pop());  // Output: 1
//
//            // This will throw EmptyStackException
//            System.out.println(stack2.pop());
//        } catch (java.util.EmptyStackException e) {
//            System.out.println("Stack is empty. Cannot perform pop operation.");
//        }
    }
}

/*
Stack Methods in Java
empty(): Checks if the stack is empty.
peek(): Looks at the top element without removing it.
pop(): Removes and returns the top element.
push(E item): Adds an item to the top of the stack.
search(Object o): Finds the position of an element in the stack (1-based index).
stack.size() returns the number of elements in the stack.
 */
