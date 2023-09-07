package csci2320;

public interface Seq<E> {
    E get(int index);
    void set(int index, E elem); //overriding ;; order 1
    void add(E elem); //adding at the end ;; order 1
    void insert(int index, E elem); //adding new at index;; order N operation 
    E remove(int index); // order N operation 
    int size();
    boolean isEmpty();
}
