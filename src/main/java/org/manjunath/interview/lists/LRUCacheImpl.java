package org.manjunath.interview.lists;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        System.out.println("Initialized the cache");
        cache.printCache();

        System.out.println("fetch cache for 1: "+cache.get(1));
        cache.put(1, 10);
        cache.put(2, 20);

        cache.printCache();
        System.out.println("fetch cache for 1: "+cache.get(1));

        cache.printCache();

        cache.put(3, 30);
        cache.printCache();

        cache.put(2, 40);
        cache.printCache();

        cache.put(1, 100);
        cache.printCache();

        System.out.println("fetch cache for 1: "+cache.get(2));
        cache.printCache();
    }
}

class LRUCache {
    private final ListNode head;
    private final ListNode tail;
    private final Map<Integer, ListNode> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // Retrieve the Entry from the map.
            ListNode listNode = map.get(key);

            // Remove entry from the LinkedList as it need to be updated as recently used data.
            remove(listNode);

            // Insert the data at the front of Linked List
            insert(listNode.key, listNode.value);

            return listNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // if the data exist for the key provided, then remove from the Map
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            remove(tail.prev);
        }

        insert(key, value);
    }

    private void insert(int key, int value) {
        // Create new node and insert it at front of the LinkedList.
        ListNode newNode = new ListNode(key, value);
        newNode.next = head.next;
        newNode.prev = head;

        head.next.prev = newNode;
        head.next = newNode;

        // Add newly created entry into the HashMap
        map.put(key, newNode);
    }

    private void remove(ListNode node) {
        // remove the entry from the Hashmap.
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void printCache() {
        ListNode temp = head.next;
        System.out.print("head -> ");
        while (temp.next != null) {
            System.out.printf("[%d:%d] -> ", temp.key, temp.value);
            temp = temp.next;
        }
        System.out.println("tail");
    }

}

class ListNode {
    ListNode prev;
    int key;
    int value;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
