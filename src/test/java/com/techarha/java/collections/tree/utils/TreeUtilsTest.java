package com.techarha.java.collections.tree.utils;

import com.techarha.java.collections.tree.bst.CustomTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeUtilsTest {

    @Test
    public void isBst() {
        CustomTree.BinaryTreeNode<Integer> binaryTreeNode = generateRandomBinaryTree();
        CustomTree.BinaryTreeNode<Integer> bstTreeNode = generateRandomBstTree();

        assertEquals(false, TreeUtils.isBst(binaryTreeNode));
        assertEquals(true, TreeUtils.isBst(bstTreeNode));
    }

    private CustomTree.BinaryTreeNode<Integer> generateRandomBinaryTree() {
        Integer[] dataArray = { 10, 8, 22, 6, 9, 14, 24, 4, 7, 19, 16, 13};
        return TreeUtils.createTreeFromArray(dataArray);
    }

    private CustomTree.BinaryTreeNode<Integer> generateRandomBstTree() {
        Integer[] dataArray = { 16, 8, 22, 6, 13, 19, 24, 4, 7, 10, 14, 17};
        return TreeUtils.createTreeFromArray(dataArray);
    }
}
