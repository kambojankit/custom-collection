package com.techarha.java.collections.list;

import static java.util.Objects.isNull;

public class CustomLinkedList<T> implements CustomList<T> {

    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
    }

    @Override
    public void addToFront(T data) {
        Node<T> currentNode = new Node<>(data);

        if(!isEmpty()) {
            currentNode.setNext(head);
        }
        head = currentNode;
        size++;
    }

    @Override
    public void removeFromFront() {
        if(isEmpty()) return;

        Node<T> temp = head;
        head = temp.getNext();
        temp.setData(null);
        temp.setNext(null);
        size--;
    }

    @Override
    public void addToEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if(isEmpty())
            head = newNode;
        else {
            Node<T> currentNode = head;
            while(currentNode.getNext() != null)
                currentNode = currentNode.getNext();

            currentNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void removeFromEnd() {
        if(isEmpty()) return;

        Node<T> currentNode = head;
        Node<T> prevNode = currentNode;
        while(currentNode.getNext() != null) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if(head == currentNode) head = null;

        prevNode.setNext(null);
        currentNode.setData(null);
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
        Node<T> dataNode = null;
        while(currentNode.getNext() != null) {
            Node<T> nextNode = currentNode.getNext();
            if(!isNull(nextNode) && nextNode.getData().equals(data)) {
                dataNode = nextNode;
                break;
            }
            currentNode = nextNode;
        }

        if(dataNode != null) {
            currentNode.setNext(dataNode.getNext());
            dataNode.setData(null);
            dataNode.setNext(null);
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
            Node<T> prevNode = currentNode;
            while (iter < index) {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
                iter++;
            }

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
            Node<T> previous = head;
            while (iter < index) {
                previous = currentNode;
                currentNode = currentNode.getNext();
                iter++;
            }
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

    public void reverseList(boolean isRecursive) {
        if(isRecursive)
            reverseListRecursive(head);
        else
            reverseListIterative();
    }

    @Override
    public String toString() {
        return printListIterative(",");
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

    public String printListIterative() {
        return printListIterative(" ->");
    }

    public String printListRecursive() {
        return printListRecursive(head);
    }

    private String printListIterative(String separator) {
        if(isEmpty()) return "";

        StringBuffer buff = new StringBuffer();
        Node<T> temp = head;
        do {
            buff.append(temp.getData());
            if(temp.getNext() != null) {
                buff.append(separator + " ");
            }

            temp = temp.getNext();
        } while(temp != null);

        return buff.toString();
    }

    private String printListRecursive(Node<T> node) {
        if(node == null) return "";
        return node.getData().toString() + ", " + printListRecursive(node.getNext());
    }

    private void reverseListIterative() {
        if(isEmpty()) return;

        Node<T> current = head;
        Node<T> next = head.getNext();
        Node<T> previous = null;

        while(current != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            if(!isNull(next)) next = next.getNext();
        }

        head = previous;
    }

    private Node<T> reverseListRecursive(Node<T> currentNode) {
        if(currentNode.getNext() == null) {
            head = currentNode;
            return currentNode;
        }
        Node<T> nextNode = reverseListRecursive(currentNode.getNext());
        nextNode.setNext(currentNode);
        currentNode.setNext(null);
        return currentNode;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

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
    }
}
