/*Implement a Custom Hash Map
Problem: Design and implement a basic hash map class with operations for insertion, deletion, and retrieval.
Hint: Use an array of linked lists to handle collisions using separate chaining.*/
package com.hashmapandhashfunction;

class Node {
    int key, value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap {
    private int size;
    private Node[] storage;

    public CustomHashMap(int size) {
        this.size = size;
        this.storage = new Node[size];
    }

    private int computeHash(int key) {
        return (key * 31) % size;
    }

    public void insert(int key, int value) {
        int index = computeHash(key);
        if (storage[index] == null) {
            storage[index] = new Node(key, value);
        } else {
            Node current = storage[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Node(key, value);
        }
    }

    public int retrieve(int key) {
        int index = computeHash(key);
        Node current = storage[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void delete(int key) {
        int index = computeHash(key);
        Node current = storage[index];
        Node previous = null;
        while (current != null) {
            if (current.key == key) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    storage[index] = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap(10);
        map.insert(1, 100);
        map.insert(2, 200);
        System.out.println("Value for key 1: " + map.retrieve(1));
        System.out.println("Value for key 2: " + map.retrieve(2));
        map.delete(1);
        System.out.println("Value for key 1 after deletion: " + map.retrieve(1));
    }
}