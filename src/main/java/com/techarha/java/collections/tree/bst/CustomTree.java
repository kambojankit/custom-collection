package com.techarha.java.collections.tree.bst;

import static java.util.Objects.isNull;

public interface CustomTree<T extends Comparable<T>> {
    void insert(T data);
    void remove(T data);
    BinaryTreeNode<T> search(T data);
    boolean isEmpty();
    int getHeight();
    T findMax();
    T findMin();
    String levelOrderTraversal();
    String preOrderTraversal();
    String inOrderTraversal();
    String postOrderTraversal();

    T inorderSuccessor(T data);

    class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        T data;

        public BinaryTreeNode(T data) {
            this.data = data;
        }

        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode<T> left) {
            this.left = left;
        }

        public BinaryTreeNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode<T> right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public boolean isLeafNode() {
            return isNull(left) && isNull(right);
        }

        @Override
        public int compareTo(BinaryTreeNode<T> that) {
            return this.data.compareTo(that.data);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
