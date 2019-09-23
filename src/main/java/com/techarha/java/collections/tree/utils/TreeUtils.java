package com.techarha.java.collections.tree.utils;

import com.techarha.java.collections.tree.bst.CustomTree;

import static java.util.Objects.isNull;

public class TreeUtils {

    public static boolean isBst(CustomTree.BinaryTreeNode<Integer> rootNode) {
        return checkBst(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static CustomTree.BinaryTreeNode<Integer> createTreeFromArray(Integer[] array) {
        if(array.length==0) return null;
        return createTree(array, 0);
    }

    private static boolean checkBst(CustomTree.BinaryTreeNode<Integer> rootNode, int minValue, int maxValue) {
        if(isInRange(rootNode.getData(), minValue, maxValue)) {
            boolean isLeftBst = !isNull(rootNode.getLeft()) ? checkBst(rootNode.getLeft(), minValue, rootNode.getData()) : true;
            boolean isRightBst = !isNull(rootNode.getRight()) ? checkBst(rootNode.getRight(), rootNode.getData(), maxValue) : true;

            return isLeftBst && isRightBst;
        } else
            return false;
    }

    private static boolean isInRange(int data, int minValue, int maxValue) {
        return data > minValue && data <= maxValue;
    }

    private static CustomTree.BinaryTreeNode<Integer> createTree(Integer[] input, int index) {
        if(index >= input.length) {
            return null;
        }
        Integer rootData = input[index];
        CustomTree.BinaryTreeNode<Integer> leftNode = createTree(input, getLeftIndex(index));
        CustomTree.BinaryTreeNode<Integer> rightNode = createTree(input, getRightIndex(index));

        CustomTree.BinaryTreeNode<Integer> rootNode = new CustomTree.BinaryTreeNode<>(rootData);
        rootNode.setLeft(leftNode);
        rootNode.setRight(rightNode);

        return rootNode;
    }

    private static int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightIndex(int index) {
        return 2 * index + 2;
    }
}
