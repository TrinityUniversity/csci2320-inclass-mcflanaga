package csci2320;

import java.util.List;

public class GeneralTree<E> {
    public class Node<E> {
        E data;
        List<Node<E>> children;
    }
    
    private Node<E> root;
}
