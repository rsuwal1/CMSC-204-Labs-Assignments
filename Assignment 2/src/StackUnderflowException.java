
public class StackUnderflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for stack underflow
     */
    public StackUnderflowException() {
        super("The stack is empty");
    }
}