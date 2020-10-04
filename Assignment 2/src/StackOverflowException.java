
public class StackOverflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for stack overflow
     */
    public StackOverflowException() {
        super("The empty is full");
    }
}