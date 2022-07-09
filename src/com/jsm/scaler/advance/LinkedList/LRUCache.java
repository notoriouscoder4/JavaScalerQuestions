package com.jsm.scaler.advance.LinkedList;

import java.util.HashMap;

public class LRUCache {
    /*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
    it should invalidate the least recently used item before inserting the new item.
    The LRUCache will be initialized with an integer corresponding to its capacity.
    Capacity indicates the maximum number of unique keys it can hold at a time.

    Definition of "least recently used" : Access to an item is defined as a get or a set operation of the item.
    "Least recently used" item is the one with the oldest access time.

    NOTE: If you are using any global variables, make sure to clear them in the constructor.

    Example :
    Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
    */

    // Create the Doubly LinkedList Class
    private static class DoublyLinkedList {
        int key;
        int value;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        public DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private static int capacity;

    //HashMap to store the Key Value and DoublyLinkedList Address
    private static HashMap<Integer, DoublyLinkedList> cache;

    //HeadNode & TailNode to keep track of the list
    private static DoublyLinkedList head = null;
    private static DoublyLinkedList tail = null;

    private LRUCache(int capacity) {
        LRUCache.capacity = capacity;
        cache = new HashMap<>(LRUCache.capacity);
    }

    private static int get(int key) {
        if (cache.containsKey(key)) {
            DoublyLinkedList curr = cache.get(key);

            // If the key is the last node then we don't have to remove it and insert it again.
            // We will delete the node and insert it at the last for other nodes
            if (curr.next != null) {
                removeNode(curr);
                insertAtLast(curr);
            }
            return curr.value;
        }
        return -1;
    }

    private static void set(int key, int value) {
        if (cache.containsKey(key)) {
            DoublyLinkedList updateNode = cache.get(key);
            updateNode.value = value;

            // If the node is not the last then remove the node and its entry in hashmap and then again
            // insert the node with new value.
            if (updateNode.next != null) {
                removeNode(updateNode);
                cache.remove(updateNode.key);
                updateNode = new DoublyLinkedList(key, value);
                cache.put(key, updateNode);
                insertAtLast(updateNode);
            }
        } else {
            DoublyLinkedList newNode = new DoublyLinkedList(key, value);
            if (cache.size() == capacity) {
                DoublyLinkedList deleteNode = removeHeadNode();
                cache.remove(deleteNode.key);
                cache.put(key, newNode);
                insertAtLast(newNode);
            } else {
                cache.put(key, newNode);
                insertAtLast(newNode);
            }
        }
    }

    private static void removeNode(DoublyLinkedList currNode) {
        // Condition for checking if it is a single node
        if (currNode.next == null && currNode.prev == null) {
            head = null;
            tail = null;
            return;
        }

        // Condition to check if the node is last node and update the tailNode
        if (currNode == tail) {
            tail = currNode.prev;
            return;
        }

        // If the head is pointing to the currentNode point it to the nextNode
        if (head == currNode)
            head = head.next;
        DoublyLinkedList currPrevNode = currNode.prev;
        DoublyLinkedList currNextNode = currNode.next;
        currNextNode.prev = currPrevNode;

        if (currPrevNode != null)
            currPrevNode.next = currNextNode;
    }

    private static void insertAtLast(DoublyLinkedList currNode) {
        if (head == null) {
            head = currNode;
            tail = currNode;
            return;
        }
        tail.next = currNode;
        currNode.prev = tail;
        tail = currNode;
    }

    private static DoublyLinkedList removeHeadNode() {
        DoublyLinkedList deleteNode = head;
        if (head.next == null && head.prev == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return deleteNode;
    }
}
