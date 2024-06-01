package _18_Stacks_And_Queue.CustomStacks;

//Implemented Custom Stacks Using array.
public class CustomStacks {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int top = -1;

    // Calling another constructor from a constructor using the `this` keyword.
    public CustomStacks() {
        this(DEFAULT_SIZE); // size will be 10
    }

    // If we pass size as an argument, this constructor will be called.
    public CustomStacks(int size) {
        this.data = new int[size]; // size will be whatever is passed as an argument.
    }

    // Inserting an element into the stack.
    public boolean push(int item) {

        // If the array (data) is full, we cannot insert the element.
        if (isFull()) {
            System.out.println("Stack is full!!");
            return false;
        }

        // Increase the pointer and add the item.
        top++;
        data[top] = item;
        return true;
    }

    // Removing an element from the stack.
    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop from an empty stack!!");
        }

        /*
       return remove item.
       int remove = data[top];

       removing element from the last in stack
       top--;

        return remove;
        */

        //In simple term :
        //Return and remove the item.
        return data[top--];
    }

    // Peek is a function that returns the element at the top of the stack without removing it.
    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot peek from an empty stack!!");
        }

        // Return the top element.
        return data[top];
    }

    // Checking if the stack is full.
    public boolean isFull() {
        return top == data.length - 1; // top is at the last index.
    }

    // Checking if the stack is empty.
    public boolean isEmpty() {
        return top == -1; // top is at the default -1.
    }

    // Display the elements of the queue
    public void display() {
        for (int i = 0; i <=top; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}

/*
 Key Points:
Default Constructor: Removed top++ as it is unnecessary.
Push Method: Correctly handles stack overflow by checking if the stack is full before pushing an element.
Pop Method: Correctly handles stack underflow by checking if the stack is empty before popping an element.
Peek Method: Provides a safe way to look at the top element without removing it, with appropriate checks for underflow.
isFull() and isEmpty() Methods: Accurately determine the status of the stack
*/
