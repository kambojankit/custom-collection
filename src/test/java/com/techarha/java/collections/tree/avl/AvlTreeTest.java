package com.techarha.java.collections.tree.avl;

import com.techarha.java.collections.tree.bst.CustomLinkedBstTree;
import com.techarha.java.collections.tree.bst.CustomTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTreeTest {

    AvlTree<Integer> avlTree;

    @Before
    public void setUp() throws Exception {
        avlTree = new AvlTree<>();
        avlTree.add(43);
        avlTree.add(18);
        avlTree.add(22);
        avlTree.add(9);
        avlTree.add(21);
        avlTree.add(6);
        avlTree.add(8);
        avlTree.add(20);
        avlTree.add(63);
        avlTree.add(50);
        avlTree.add(62);
        avlTree.add(61);
    }


    @Test
    public void add() {
        assertEquals("22 18 50 8 21 43 62 6 9 20 61 63", avlTree.toString());
    }
}
