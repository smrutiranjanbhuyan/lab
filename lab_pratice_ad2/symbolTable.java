package lab_pratice_ad2;

import java.util.*;

public class symbolTable<K, V> {
    private Map<K, V> map;

    public symbolTable() {
        map = new HashMap<>();
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public boolean contains(K key) {
        return map.containsKey(key);
    }

    public void delete(K key) {
        map.remove(key);
    }

    public Iterable<K> keys() {
        return map.keySet();
    }

    public static void main(String[] args) {
        symbolTable<String, Integer> st = new symbolTable<>();
        st.put("one", 1);
        st.put("two", 2);
        st.put("three", 3);

        System.out.println("Value for 'two': " + st.get("two"));
        System.out.println("Contains 'three': " + st.contains("three"));
        st.delete("two");
        System.out.println("Contains 'two' after deletion: " + st.contains("two"));
        System.out.println("Keys: " + st.keys());
    }
}
