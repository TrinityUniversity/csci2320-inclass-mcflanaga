package csci2320;

public interface Queue<E> {
    void enqueue(E elem);
    E dequeue();
    E peek();
    boolean isEmpty();
    
    static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String message) {
            super(message);
        }
    }
}
