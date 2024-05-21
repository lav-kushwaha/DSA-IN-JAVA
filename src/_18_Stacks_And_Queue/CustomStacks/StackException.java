package _18_Stacks_And_Queue.CustomStacks;

//creating seprated class for Exception
public class StackException extends Exception { //class StackException that extends the built-in Exception class.

    public StackException(String message){
        // Constructor that takes a message and passes it to the parent Exception class
       super(message);
    }

}
