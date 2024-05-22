package _18_Stacks_And_Queue.CustomStacks;

public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStacks stack = new CustomStacks(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

//        stack.push(30); //This will give msg stack is full bcs we can't push value more than size 5.

        // Pop elements from the stack.
//        System.out.println(stack.pop());  // Output: 40
//        System.out.println(stack.pop());  // Output: 30
//        System.out.println(stack.pop());  // Output: 20
//        System.out.println(stack.pop());  // Output: 10

//        System.out.println(stack.pop());//Exception in thread : Cannot pop from an empty stack!!



        //=============Dynamic Stacks=======================================

        //Note : dynamic stack never get full it will double the size of the array every time.
        DynamicStacks dynamicStacks = new DynamicStacks(5);
        dynamicStacks.push(10);
        dynamicStacks.push(20);
        dynamicStacks.push(30);
        dynamicStacks.push(40);
        dynamicStacks.push(50);


        dynamicStacks.push(30); //This will not give msg stack is full bcs we can push value more than size 5.

        // Pop elements from the stack.
        System.out.println(dynamicStacks.pop());  // Output: 30
        System.out.println(dynamicStacks.pop());  // Output: 50
        System.out.println(dynamicStacks.pop());  // Output: 40
        System.out.println(dynamicStacks.pop());  // Output: 30
        System.out.println(dynamicStacks.pop());  // Output: 20
        System.out.println(dynamicStacks.pop());  // Output: 10

    }
}
