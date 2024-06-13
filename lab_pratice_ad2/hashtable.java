package lab_pratice_ad2;

import java.util.*;

class HashTable<K, V> {
    private class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 10;
    private List<Entry<K, V>>[] table;

    public HashTable() {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        for (Entry<K, V> entry : table[hash]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[hash].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int hash = hash(key);
        for (Entry<K, V> entry : table[hash]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean contains(K key) {
        int hash = hash(key);
        for (Entry<K, V> entry : table[hash]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void delete(K key) {
        int hash = hash(key);
        table[hash].removeIf(entry -> entry.key.equals(key));
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (List<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                keys.add(entry.key);
            }
        }
        return keys;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>();
        ht.put("one", 1);
        ht.put("two", 2);
        ht.put("three", 3);

        System.out.println("Value for 'two': " + ht.get("two"));
        System.out.println("Contains 'three': " + ht.contains("three"));
        ht.delete("two");
        System.out.println("Contains 'two' after deletion: " + ht.contains("two"));
        System.out.println("Keys: " + ht.keys());
    }
}
