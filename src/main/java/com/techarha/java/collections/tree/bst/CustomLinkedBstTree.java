package com.techarha.java.collections.tree.bst;

import com.techarha.java.collections.queue.CustomListQueue;
import com.techarha.java.collections.queue.CustomQueue;
import com.techarha.java.collections.stack.CustomListStack;
import com.techarha.java.collections.stack.CustomStack;

import static java.util.Objects.isNull;

public class CustomLinkedBstTree<T extends Comparable<T>> implements CustomTree<T> {

    BinaryTreeNode<T> rootNode;

    @Override
    public void insert(T data) {
        BinaryTreeNode<T> dataNode = new BinaryTreeNode<>(data);

        if(isEmpty())
            rootNode = dataNode;
        else
            insertInTree(rootNode, dataNode);
    }

    @Override
    public void remove(T data) {
        deleteNode(rootNode, data);
    }

    public BinaryTreeNode<T> deleteNode(BinaryTreeNode<T> root, T data) {
        if(isNull(root)) return null;

        if(root.getData().compareTo(data) > 0) root.setLeft(deleteNode(root.getLeft(), data));
        else if (root.getData().compareTo(data) < 0) root.setRight(deleteNode(root.getRight(), data));
        else {
            if(root.isLeafNode()) {
                root.setData(null);
                return null;
            }

            if(isNull(root.getLeft())) {
                BinaryTreeNode<T> right = root.getRight();
                root.setRight(null);
                root.setData(null);
                return right;
            }

            if(isNull(root.getRight())) {
                BinaryTreeNode<T> left = root.getLeft();
                root.setLeft(null);
                root.setData(null);
                return left;
            }

            BinaryTreeNode<T> rightMinNode = findMinNode(root.getRight());
            root.setData(rightMinNode.getData());

            deleteNode(root.getRight(), rightMinNode.getData());
        }
        return root;
    }

    @Override
    public BinaryTreeNode<T> search(T data) {
        if(isEmpty()) return null;

        BinaryTreeNode<T> dataNode = new BinaryTreeNode<>(data);
        return searchTree(rootNode, dataNode);
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public int getHeight() {
        return getHeight(rootNode);
    }

    @Override
    public T findMax() {
        return findMaxNode(rootNode).getData();
    }

    @Override
    public T findMin() {
        return findMinNode(rootNode).getData();
    }

    private BinaryTreeNode<T> findMaxNode(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> currentNode = root;
        while (currentNode.getRight() != null){
            currentNode = currentNode.getRight();
        }
        return currentNode;
    }

    private BinaryTreeNode<T> findMinNode(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> currentNode = root;
        while (!isNull(currentNode.getLeft())) {
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    @Override
    public String levelOrderTraversal() {
        return levelOrderTraversal(rootNode);
    }

    @Override
    public String preOrderTraversal() {
        return preOrderTraversal(rootNode).replaceAll("\\s+", " ");
    }

    @Override
    public String inOrderTraversal() {
        return inOrderTraversal(rootNode).replaceAll("\\s+", " ");
    }

    @Override
    public String postOrderTraversal() {
        return postOrderTraversal(rootNode).replaceAll("\\s+", " ");
    }

    @Override
    public T inorderSuccessor(T data) {
        return inorderSuccessor(rootNode, data, new CustomListStack<>());
    }

    @Override
    public String toString() {
        return printTree();
    }

    public String printTree() {
        return levelOrderTraversal(rootNode);
    }

    public String printSubTree(BinaryTreeNode<T> node) {
        return levelOrderTraversal(node);
    }

    private T inorderSuccessor(BinaryTreeNode<T> root, T data, CustomStack<T> stack) {
        if(isNull(root)) return null;

        if(root.getData().compareTo(data) > 0) {
            stack.push(root.getData());
            return inorderSuccessor(root.getLeft(), data, stack);
        }

        if(root.getData().compareTo(data) < 0) {
            stack.push(root.getData());
            return inorderSuccessor(root.getRight(), data, stack);
        }

        if(!isNull(root.getRight())) {
            return findMinNode(root.getRight()).getData();
        }

        while (!stack.isEmpty() && stack.peek().compareTo(data) <= 0) {
            stack.pop();
        }

        return stack.peek();
    }

    private String preOrderTraversal(BinaryTreeNode<T> root) {
        if(root == null) return "";
        if(root.isLeafNode()) return root.data + "";

        String left = preOrderTraversal(root.getLeft());
        String right = preOrderTraversal(root.getRight());
        String rootData = root.getData().toString();

        return rootData + " " + left + " " + right;
    }

    private String inOrderTraversal(BinaryTreeNode<T> root) {
        if(root == null) return "";
        if(root.isLeafNode()) return root.data + "";

        String left = inOrderTraversal(root.getLeft());
        String current = root.getData().toString();
        String right = inOrderTraversal(root.getRight());

        return left + " " + current + " " + right;
    }

    private String postOrderTraversal(BinaryTreeNode<T> root) {
        if(root == null) return "";
        if(root.isLeafNode()) return root.data + "";

        String left = postOrderTraversal(root.getLeft());
        String right = postOrderTraversal(root.getRight());
        String current = root.getData().toString();

        return left + " " + right + " " + current;
    }

    private String levelOrderTraversal(BinaryTreeNode<T> root) {
        if(isNull(root)) return "";

        StringBuffer buffer = new StringBuffer();

        CustomQueue<BinaryTreeNode<T>> queue = new CustomListQueue<>();
        queue.enqueue(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();
            buffer.append(current + " ");

            if(!isNull(current.getLeft())) queue.enqueue(current.getLeft());
            if(!isNull(current.getRight())) queue.enqueue(current.getRight());
        }

        buffer.deleteCharAt(buffer.lastIndexOf(" "));
        return buffer.toString();
    }

    private int getHeight(BinaryTreeNode<T> current) {
        if(current.isLeafNode()) return 0;
        else {
            int leftHeight = isNull(current.getLeft()) ? 0 : getHeight(current.getLeft());
            int rightHeight = isNull(current.getRight()) ? 0 : getHeight(current.getRight());
            return Integer.max(leftHeight, rightHeight) + 1;
        }
    }

    private BinaryTreeNode<T> searchTree(BinaryTreeNode<T> rootNode, BinaryTreeNode<T> dataNode) {
        if(isRootEqualToData(rootNode, dataNode)) return rootNode;

        return isRootLessThanData(rootNode, dataNode)
                    ? searchTree(rootNode.getRight(), dataNode)
                    : searchTree(rootNode.getLeft(), dataNode);
    }

    private void insertInTree(BinaryTreeNode<T> rootNode, BinaryTreeNode<T> dataNode) {

        if(isRootLessThanEqualData(rootNode, dataNode))
            if(rootNode.isLeafNode() || isNull(rootNode.getRight())) rootNode.setRight(dataNode);
            else insertInTree(rootNode.getRight(), dataNode);
        else
            if(rootNode.isLeafNode() || isNull(rootNode.getLeft())) rootNode.setLeft(dataNode);
            else insertInTree(rootNode.getLeft(), dataNode);
    }

    private boolean isRootLessThanEqualData(BinaryTreeNode<T> root, BinaryTreeNode<T> data) {
        return isRootLessThanData(root, data) || isRootEqualToData(root, data);
    }

    private boolean isRootLessThanData(BinaryTreeNode<T> root, BinaryTreeNode<T> data) {
        return root.compareTo(data) < 0;
    }

    private boolean isRootEqualToData(BinaryTreeNode<T> root, BinaryTreeNode<T> data) {
        return root.compareTo(data) == 0;
    }
}
