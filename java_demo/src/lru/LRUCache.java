package lru;

import java.util.HashMap;
import java.util.Map;


/**
 * @author dzq
 * @Date 2024/11/23 10:04
 * @Description
 */
public class LRUCache {
    private int size, capacity; //当前大小、最大容量
    private Node head, tail; //头尾节点
    private Map<Integer, Node> dataMap;
    LRUCache(){}
    LRUCache(int capacity) {
        dataMap = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    //Node内部类
    class Node {
        int key, value;
        Node prev, next;
        Node(){}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, int value) {
        Node newNode;
        if (dataMap.containsKey(key)) {
            newNode = dataMap.get(key);
            newNode.value = value;
            moveNodeToHead(newNode);
        } else {
            newNode = new Node(key, value);
            if (size >= capacity) {
                Node toDelete = tail.prev;
                deleteNode(toDelete);
                dataMap.remove(toDelete.key);
            }
            insertNodeIntoHead(newNode);
        }
        size++;
        dataMap.put(key, newNode);
    }

    public int get(int key) {
        if (dataMap.containsKey(key)) {
            Node res = dataMap.get(key);
            moveNodeToHead(res);
            return res.value;
        }
        return -1;
    }

    public int top() {
        if (size == 0) {
            return -1;
        }
        return dataMap.get(head.next.key).value;
    }

    public void moveNodeToHead(Node node) {
        deleteNode(node);
        insertNodeIntoHead(node);
    }

    public void deleteNode(Node toDelete) {
        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
        size--;
    }

    public void insertNodeIntoHead(Node toInsert) {
        toInsert.next = head.next;
        head.next.prev = toInsert;
        head.next = toInsert;
        toInsert.prev = head;
    }
}
