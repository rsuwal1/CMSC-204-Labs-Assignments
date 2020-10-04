
public class QueueUnderflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for queue underflow
     */
    public QueueUnderflowException() {
        super("The queue is empty");
    }
}