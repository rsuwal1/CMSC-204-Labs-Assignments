
public class QueueOverflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for queue overflow
     */
    public QueueOverflowException() {
        super("The queue is full");
    }
}