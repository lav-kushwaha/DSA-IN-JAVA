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

//Note : we have to convert stack that gives the output like queues, and we will use all stacks method.
//FIFO(Queue) -> LIFO(Stack)

/*
#Amortised meaning.
Amortised means that only one time, when we move stack1 to stack2, it will take O(n) time complexity;
after that, it will take O(1) for push and pop.
*/

/*
#Amortised Analysis
In the worst-case scenario, during the first dequeue operation, we moved 2 elements from stack1 to stack2, costing O(n) time (where n is the number of elements moved).
However, each element is only moved once from stack1 to stack2 in its lifetime.
Therefore, over a sequence of n enqueue and dequeue operations, the total cost of moving elements is O(n).
Each enqueue operation is O(1).
Each dequeue operation, except for the transfers, is O(1).
 */