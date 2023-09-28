package csci2320;

import java.util.function.Consumer;

public class OrderedSet<E extends Comparable<E>> {
  private static class Node<E extends Comparable<E>> {
    E data;
    E min, max;
    Node<E> left, right;
    Node(E elem, Node<E> left, Node<E> right) {
      data = elem;
      min = elem;
      max = elem;
      this.left = left;
      this.right = right;
    }
    void checkMinMax(E elem) {
      if (elem.compareTo(min) < 0) min = elem;
      if (elem.compareTo(max) > 0) max = elem;
    }
  }
  private Node<E> root = null;

  public boolean contains(E elem) {
    Node<E> rover = root;
    while (rover != null && !rover.data.equals(elem)) {
      int comp = elem.compareTo(rover.data); 
      if (comp < 0) rover = rover.left;
      else rover = rover.right;
    }
    return rover != null;
  }

  public boolean add(E elem) {
    if (root == null) {
      root = new Node<E>(elem, null, null);
      return true;
    } else {
      Node<E> rover = root;
      Node<E> trailer = null;
      int comp = 0;
      while (rover != null && !rover.data.equals(elem)) {
        rover.checkMinMax(elem);
        trailer = rover;
        comp = elem.compareTo(rover.data); 
        if (comp < 0) rover = rover.left;
        else rover = rover.right;
      } 
      if (rover != null) {
        return false;
      } else {
        if (comp < 0) trailer.left = new Node<>(elem, null, null);
        else trailer.right = new Node<>(elem, null, null);
        return true;
      }
    }
    
  }

  public OrderedSet<E> searchRange(E min, E max) {
    OrderedSet<E> set = new OrderedSet<>();
    searchRangeRecur(root, min, max, set);
    return set;
  }
  private void searchRangeRecur(Node<E> n, E min, E max, OrderedSet<E> set) {
    if (n != null && n.min.compareTo(max) <= 0 && n.max.compareTo(min) >= 0) {
      if (n.data.compareTo(min) >= 0 && n.data.compareTo(max) <= 0) set.add(n.data);
      searchRangeRecur(n.left, min, max, set);
      searchRangeRecur(n.right, min, max, set);
    }
  }

  public int size() {
    return sizeRecur(root);
  }

  private int sizeRecur(Node<E> n) {
    if (n == null) return 0;
    else return sizeRecur(n.left) + sizeRecur(n.right) + 1;
  }

  public int height() {
    return heightRecur(root);
  }

  private int heightRecur(Node<E> n) {
    if (n == null) return 0;
    else return Math.max(heightRecur(n.left), heightRecur(n.right)) + 1; 
  }


  public String toStringPreorder() {
    StringBuilder sb = new StringBuilder("pre : ");
    preorder(root, e -> sb.append(e.toString() + " "));
    return sb.toString();
  }


  private void preorder(Node<E> n, Consumer<E> visitor) {
    if (n != null) {
      visitor.accept(n.data);
      preorder(n.left, visitor);
      preorder(n.right, visitor);
    }
  }

  public String toStringPostorder() {
    StringBuilder sb = new StringBuilder("post : ");
    postorder(root, e -> sb.append(e.toString() + " "));
    return sb.toString();
  }

  private void postorder(Node<E> n, Consumer<E> visitor) {
    if (n != null) {
      postorder(n.left, visitor);
      postorder(n.right, visitor);
      visitor.accept(n.data);
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("OrderedSet ( ");
    inorder(root, e -> sb.append(e.toString() + " "));
    sb.append(")");
    return sb.toString();
  }

  private void inorder(Node<E> n, Consumer<E> visitor) {
    if (n != null) {
      inorder(n.left, visitor);
      visitor.accept(n.data);
      inorder(n.right, visitor);
    }
  }
}
