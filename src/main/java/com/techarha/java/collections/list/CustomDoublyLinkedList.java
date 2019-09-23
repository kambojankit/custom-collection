package com.techarha.java.collections.list;

import static java.util.Objects.isNull;

public class CustomDoublyLinkedList<T> implements CustomList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomDoublyLinkedList() {
        this.head = null;
    }

    @Override
    public void addToFront(T data) {
        Node<T> currentNode = new Node<>(data);

        if(!isEmpty()) {
            head.setPrevious(currentNode);
            currentNode.setNext(head);
        }else {
            tail = currentNode;
        }

        head = currentNode;
        size++;
    }

    @Override
    public void removeFromFront() {
        if(isEmpty()) return;

        Node<T> temp = head;
        head = temp.getNext();

        if (head != null) head.setPrevious(temp.getPrevious());

        if(temp == tail) tail = null;

        temp.setData(null);
        temp.setNext(null);
        temp.setPrevious(null);
        size--;

    }

    @Override
    public void addToEnd(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setPrevious(tail);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    @Override
    public void removeFromEnd() {
        if(isEmpty()) return;

        Node<T> temp = tail;

        tail = tail.getPrevious();
        if(!isNull(tail)) tail.setNext(temp.getNext());

        if(temp == head) head = null;
        temp.setData(null);
        temp.setPrevious(null);

        size--;
    }

    @Override
    public boolean insert(T data) {
        addToEnd(data);
        return true;
    }

    @Override
    public boolean remove(T data) {
        if(isEmpty() || isNull(data)) return false;

        Node<T> currentNode = head;
        while(currentNode.getNext() != null) {
            if(currentNode.getData().equals(data))
                break;
            currentNode = currentNode.getNext();
        }

        if(currentNode.getData().equals(data)) {
            Node<T> prevNode = currentNode.getPrevious();
            prevNode.setNext(currentNode.getNext());
            currentNode.setData(null);
            currentNode.setNext(null);
            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean removeAt(int index) {
        if(isEmpty() || index < 0 || index >= size) return false;

        if(index == 0) removeFromFront();
        else if(index == size - 1) removeFromEnd();
        else {
            int iter = 0;
            Node<T> currentNode = head;
            while (iter < index) {
                currentNode = currentNode.getNext();
                iter++;
            }

            Node<T> prevNode = currentNode.getPrevious();
            prevNode.setNext(currentNode.getNext());
            currentNode.setData(null);
            size--;
        }
        return true;
    }

    @Override
    public T get(int index) {
        if(isEmpty() || index < 0 || index >= size) return null;

        int iter = 0;
        Node<T> currentNode = head;
        while (iter < index) {
            currentNode = currentNode.getNext();
            iter++;
        }
        return currentNode.getData();
    }

    @Override
    public boolean set(int index, T data) {
        if(isEmpty() || index < 0 || index > size) return false;

        if (index == 0) addToFront(data);
        else if(index == size) addToEnd(data);
        else {
            int iter = 0;
            Node<T> currentNode = head;
            while (iter < index) {
                currentNode = currentNode.getNext();
                iter++;
            }
            Node<T> previous = currentNode.getPrevious();
            Node<T> dataNode = new Node<>(data);
            dataNode.setNext(currentNode);
            previous.setNext(dataNode);
            size++;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return printListIterative();
    }

    @Override
    public boolean contains(T data) {
        if(isEmpty()) return false;

        Node<T> current = head;
        while (current != null) {
            if(current.getData().equals(data)) {
                return true;
            }
            current = head.getNext();
        }
        return false;
    }

    private String printListIterative() {
        if(isEmpty()) return "";

        StringBuffer buff = new StringBuffer();
        Node<T> temp = head;
        do {
            buff.append(temp.getData());
            if(temp.getNext() != null) {
                buff.append(", ");
            }

            temp = temp.getNext();
        } while(temp != null);

        return buff.toString();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
