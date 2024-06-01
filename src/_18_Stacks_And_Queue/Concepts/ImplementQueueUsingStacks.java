package _18_Stacks_And_Queue.Concepts;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
//232. Implement Queue using Stacks

class ImplementQueueUsingStacks {
    private Stack<Integer> input;
    private Stack<Integer> output;
    private int peekEle;

    public ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        if (input.isEmpty()) {
            peekEle = x;
        }
        input.push(x);// ye toh har baar karna hai
    }

    public int pop() {
        // O(n)
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            return peekEle;
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // returns 1
        System.out.println(queue.pop());  // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
