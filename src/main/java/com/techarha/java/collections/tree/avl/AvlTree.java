package com.techarha.java.collections.tree.avl;

import com.techarha.java.collections.queue.CustomListQueue;
import com.techarha.java.collections.queue.CustomQueue;

import static java.util.Objects.isNull;

public class AvlTree<E extends Comparable<E>> {
    private AvlNode<E> root;
    private int currentSize;

    public AvlTree() {
        root = null;
        currentSize = 0;
    }

    public void add(E data) {
        AvlNode<E> node = new AvlNode<>(data);

        if(isNull(root)) {
            root = node;
            currentSize++;
            return;
        }

        add(root, node);
    }

    @Override
    public String toString() {
        return printTree();
    }

    private void add(AvlNode<E> rootNode, AvlNode<E> newNode) {
        if(newNode.data.compareTo(rootNode.data) > 0) {
            if(isNull(rootNode.right)) {
                rootNode.right = newNode;
                newNode.parent = rootNode;
                currentSize++;
            }else {
                add(rootNode.right, newNode);
            }
        }else {
            if(isNull(rootNode.left)) {
                rootNode.left = newNode;
                newNode.parent = rootNode;
                currentSize++;
            }else {
                add(rootNode.left, newNode);
            }
        }
        checkBalance(newNode);
    }

    /**
     * Checks the difference in height of the tree. If its more than 1, we need to re-balance the tree
     * @param node
     */
    private void checkBalance(AvlNode<E> node) {
        if(Math.abs(getHeight(node.left) - getHeight(node.right)) > 1 ) {
            rebalance(node);
        }
        if (isNull(node.parent)) return;

        checkBalance(node.parent);
    }

    private void rebalance(AvlNode<E> node) {
        AvlNode<E> parent = isNull(node.parent) ? node : node.parent;
        AvlNode<E> rotated;
        if(getHeight(node.left) - getHeight(node.right) > 1) {
            if(getHeight(node.left.left) > getHeight(node.left.right)) {
                rotated = rightRotate(node);
            }else {
                rotated = leftRightRotate(node);
            }
        }else {
            if(getHeight(node.right.right) > getHeight(node.right.left)) {
                rotated = leftRotate(node);
            }else {
                rotated = rightLeftRotate(node);
            }
        }

        if(isNull(rotated.parent)) {
            root = rotated;
        }else {
            if(node.data.compareTo(parent.data) < 0) parent.left = rotated;
            else parent.right = rotated;
        }

    }

    private AvlNode<E> rightLeftRotate(AvlNode<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    private AvlNode<E> leftRightRotate(AvlNode<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private AvlNode<E> leftRotate(AvlNode<E> node) {
        AvlNode<E> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.parent = node.parent;
        node.parent = temp;
        return temp;
    }

    private AvlNode<E> rightRotate(AvlNode<E> node) {
        AvlNode<E> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.parent = node.parent;
        node.parent = temp;
        return temp;
    }

    private int getHeight(AvlNode root) {
        if(isNull(root)) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Integer.max(leftHeight, rightHeight) + 1;
    }

    private boolean isLeafNode(AvlNode root) {
        return isNull(root.left) && isNull(root.right);
    }

    public String printTree() {
        return levelOrderTraversal(root);
    }

    private String levelOrderTraversal(AvlNode<E> root) {
        if(isNull(root)) return "";

        StringBuffer buffer = new StringBuffer();

        CustomQueue<AvlNode<E>> queue = new CustomListQueue<>();
        queue.enqueue(root);

        while(!queue.isEmpty()) {
            AvlNode<E> current = queue.dequeue();
            buffer.append(current + " ");

            if(!isNull(current.left)) queue.enqueue(current.left);
            if(!isNull(current.right)) queue.enqueue(current.right);
        }

        buffer.deleteCharAt(buffer.lastIndexOf(" "));
        return buffer.toString();
    }

    public static class AvlNode<T extends Comparable<T>> {
        T data;
        AvlNode left;
        AvlNode right;
        AvlNode parent;

        public AvlNode(T data) {
            this.data = data;
            left = right = parent = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
