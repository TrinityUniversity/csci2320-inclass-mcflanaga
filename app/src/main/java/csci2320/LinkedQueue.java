package csci2320;

public class LinkedQueue<E> implements Queue<E>{
    private static class Node<E> {
        E data;
        Node<E> next;
        public Node(E data, Node<E> next) {
          this.data = data;
          this.next = next;
        }
    }
    private Node<E> front = null;
    private Node<E> back = null;

    @Override 
    public void enqueue(E elem) {
        if(back == null) {
            front = back = new Node<E>(elem, null);
        } else {
            back.next = new Node<E>(elem, null);
            back = back.next;
        }
    }

    @Override 
    public E dequeue() {
        var ret = front.data;
        front = front.next;
        if (front == null) back = null;
        return ret;
    }
    
    @Override 
    public E peek() {
        return front.data;
    }
    
    @Override 
    public boolean isEmpty() {
        return front == null;
    }
}