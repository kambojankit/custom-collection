package com.techarha.java.collections.tree.bst;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedBstTreeTest {

    CustomTree<Integer> bstTree;

    @Before
    public void setUp() throws Exception {
        bstTree = new CustomLinkedBstTree<>();
        bstTree.insert(10);
        bstTree.insert(22);
        bstTree.insert(14);
        bstTree.insert(16);
        bstTree.insert(12);
        bstTree.insert(13);
        bstTree.insert(8);
        bstTree.insert(6);
        bstTree.insert(9);
        bstTree.insert(4);
        bstTree.insert(7);
        bstTree.insert(24);
    }

    @Test
    public void insert() {
        assertEquals("10 8 22 6 9 14 24 4 7 12 16 13", bstTree.toString());
    }

    @Test
    public void insert2() {
        bstTree.insert(2);
        assertEquals("10 8 22 6 9 14 24 4 7 12 16 2 13", bstTree.toString());
    }

    @Test
    public void removeLeaf() {
        bstTree.remove(24);
        assertEquals("10 8 22 6 9 14 4 7 12 16 13", bstTree.toString());
    }

    @Test
    public void removeSingleChildNode_LeftExists() {
        bstTree.insert(2);
        assertEquals("10 8 22 6 9 14 24 4 7 12 16 2 13", bstTree.toString());
        bstTree.remove(4);
        assertEquals("10 8 22 6 9 14 24 2 7 12 16 13", bstTree.toString());
    }

    @Test
    public void removeSingleChildNode_RightExists() {
        bstTree.insert(2);
        assertEquals("10 8 22 6 9 14 24 4 7 12 16 2 13", bstTree.toString());
        bstTree.remove(12);
        assertEquals("10 8 22 6 9 14 24 4 7 13 16 2", bstTree.toString());
    }


    @Test
    public void deleteInternalNode() {
        bstTree.insert(2);
        bstTree.remove(24);
        bstTree.insert(29);
        assertEquals("10 8 22 6 9 14 29 4 7 12 16 2 13", bstTree.toString());
        bstTree.insert(26);
        bstTree.insert(24);
        bstTree.insert(27);
        assertEquals("10 8 22 6 9 14 29 4 7 12 16 26 2 13 24 27", bstTree.toString());
        bstTree.insert(32);
        bstTree.insert(30);
        bstTree.insert(33);
        assertEquals("10 8 22 6 9 14 29 4 7 12 16 26 32 2 13 24 27 30 33", bstTree.toString());

        bstTree.remove(29);
        assertEquals("10 8 22 6 9 14 30 4 7 12 16 26 32 2 13 24 27 33", bstTree.toString());

        bstTree.remove(22);
        assertEquals("10 8 24 6 9 14 30 4 7 12 16 26 32 2 13 27 33", bstTree.toString());

        bstTree.remove(10);
        assertEquals("12 8 24 6 9 14 30 4 7 13 16 26 32 2 27 33", bstTree.toString());

    }

    @Test
    public void search() {
        CustomTree.BinaryTreeNode<Integer> foundNode = bstTree.search(8);
        assertEquals("8 6 9 4 7", ((CustomLinkedBstTree) bstTree).printSubTree(foundNode));
    }

    @Test
    public void getHeight() {
        assertEquals(4, bstTree.getHeight());
    }

    @Test
    public void findMin() {
        assertEquals(new Integer(4), bstTree.findMin());
        bstTree.insert(2);
        assertEquals(new Integer(2), bstTree.findMin());
    }

    @Test
    public void findMax() {
        assertEquals(new Integer(24), bstTree.findMax());
        bstTree.insert(28);
        assertEquals(new Integer(28), bstTree.findMax());
    }

    @Test
    public void isEmpty() {
        bstTree = new CustomLinkedBstTree<>();
        assertEquals(true, bstTree.isEmpty());
        bstTree.insert(10);
        bstTree.insert(8);
        bstTree.insert(12);
        assertEquals(false, bstTree.isEmpty());
    }


    @Test
    public void levelOrderTraversal() {
        assertEquals("10 8 22 6 9 14 24 4 7 12 16 13", bstTree.levelOrderTraversal());
    }

    @Test
    public void preOrderTraversal() {
        assertEquals("10 8 6 4 7 9 22 14 12 13 16 24", bstTree.preOrderTraversal());
    }

    @Test
    public void inOrderTraversal() {
        assertEquals("4 6 7 8 9 10 12 13 14 16 22 24", bstTree.inOrderTraversal());
    }

    @Test
    public void postOrderTraversal() {
        assertEquals("4 7 6 9 8 13 12 16 14 24 22 10", bstTree.postOrderTraversal());
    }

    @Test
    public void inorderSuccessorTest() {
        CustomTree<Integer> tree = getRandomBst();
        assertEquals("10 8 22 6 9 14 29 4 7 12 16 26 32 2 13 24 27 30 33", tree.toString());

        assertEquals(new Integer(4), tree.inorderSuccessor(2));
        assertEquals(new Integer(8), tree.inorderSuccessor(7));
        assertEquals(new Integer(13), tree.inorderSuccessor(12));
        assertEquals(new Integer(30), tree.inorderSuccessor(29));
        assertEquals(new Integer(12), tree.inorderSuccessor(12));
    }

    private CustomTree<Integer> getRandomBst() {
        CustomTree<Integer> tree = new CustomLinkedBstTree<>();
        tree.insert(10);
        tree.insert(22);
        tree.insert(8);
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(9);
        tree.insert(29);
        tree.insert(14);
        tree.insert(12);
        tree.insert(13);
        tree.insert(16);
        tree.insert(26);
        tree.insert(24);
        tree.insert(27);
        tree.insert(32);
        tree.insert(30);
        tree.insert(33);
        return tree;
    }
}
