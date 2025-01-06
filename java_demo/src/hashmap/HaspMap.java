package hashmap;

import java.util.HashMap;

/**
 * @author dzq
 * @Date 2025/1/5 15:36
 * @Description
 */
public class HaspMap<K, V> {
    private static class HashNode<K, V> {
        final int hash;
        final K key;
        V value;
        HashNode next;
        public HashNode(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
    private double loadFactor;
    private HashNode[] elementData;
    private final int DEFAULT_CAPACITY = 16;
    private final double DEFAULT_LOAD_FACTOR = 0.75;
    private int size, capacity;

    public HaspMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HaspMap(int capacity) {
        this.capacity = DEFAULT_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        if (capacity > 0) {
            this.capacity = capacity;
        }
    }

    public HaspMap(int capacity, double loadFactor) {
        this.capacity = DEFAULT_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        if (capacity > 0) {
            this.capacity = capacity;
        }
        if (loadFactor > 0) {
            this.loadFactor = loadFactor;
        }
    }

    public void put(K key, V value) {
        ensureCapacity();
        HashNode node = new HashNode(hash(key), key, value);
        insert(node, elementData, indexOfKey(key));
        if (++size >= capacity * loadFactor) {
            resize(capacity * 2);
        }
    }

    public V get(K key) {
        if (containsKey(key)) {
            HashNode node = elementData[indexOfKey(key)];
            while (node != null && !node.key.equals(key)) {
                node = node.next;
            }
            return (V) node.value;
        }
        return null;
    }

    public void remove(K key) {
        if (!containsKey(key)) {
            return;
        }
        HashNode node = elementData[indexOfKey(key)], next = node.next;
        if (node.key.equals(key)) {
            elementData[indexOfKey(key)] = next;
            size--;
            return;
        }
        while (next != null && !next.key.equals(key)) {
            node = node.next;
            next = next.next;
        }
        node.next = next.next;
        size--;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        elementData = new HashNode[]{};
        size = 0;
    }

    public boolean containsKey(K key) {
        HashNode node = elementData[indexOfKey(key)];
        while (node != null && !node.key.equals(key)) {
            node = node.next;
        }
        return node != null;
    }

    public void resize(int newCapacity) {
        if (newCapacity < 0) return;
        HashNode[] newElementData = new HashNode[newCapacity];
        copy(elementData, newElementData, capacity, newCapacity);
        capacity = newCapacity;
    }

    private void copy(HashNode[] elementData, HashNode[] newElementData, int capacity, int newCapacity) {
        if (newElementData.length < elementData.length) return;
        for (int i = 0; i < size; i++) {
            HashNode node = elementData[i];
            if (node == null) continue;
            HashNode newNode = new HashNode(node.hash, node.key, node.value);
            if ((node.hash & capacity) == 0) {
                insert(newNode, newElementData, i);
            } else {
                insert(newNode, newElementData, i + capacity);
            }
        }
        this.elementData = newElementData;
    }

    private void insert(HashNode newNode, HashNode[] elementData, int i) {
        if (elementData[i] == null) {
            elementData[i] = newNode;
            return;
        }
        HashNode head = elementData[i];
        while (head.next != null && !head.key.equals(newNode.key)) {
            head = head.next;
        }
        if (head.key.equals(newNode.key)) {
            head.value = newNode.value;
            return;
        }
        head.next = newNode;
    }

    public int indexOfKey(K key) {
        return hash(key) & (capacity - 1);
    }

    public int hash(K key) {
        int hashcode;
        return key == null ? 0 : (hashcode = key.hashCode()) ^ (hashcode >>> 16);
    }

    public void ensureCapacity() {
        if(size == 0) {
            this.elementData = new HashNode[capacity];
            return;
        }
        if (size + 1 < capacity) return;
        resize(capacity * 2);
    }
}
