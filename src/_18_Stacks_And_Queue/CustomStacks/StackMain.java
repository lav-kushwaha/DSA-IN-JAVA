package _18_Stacks_And_Queue.CustomStacks;

public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStacks stack = new CustomStacks(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Pop elements from the stack.
        System.out.println(stack.pop());  // Output: 40
        System.out.println(stack.pop());  // Output: 30
        System.out.println(stack.pop());  // Output: 20
        System.out.println(stack.pop());  // Output: 10

//        System.out.println(stack.pop());//Exception in thread : Cannot pop from an empty stack!!
    }
}
