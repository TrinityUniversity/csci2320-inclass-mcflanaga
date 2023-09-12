package csci2320;

import java.util.Iterator;

public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean contains(K key);
    int size();
    Iterator<K> iterator();
}
