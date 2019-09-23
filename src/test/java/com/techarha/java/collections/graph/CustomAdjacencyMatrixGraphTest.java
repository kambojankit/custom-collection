package com.techarha.java.collections.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomAdjacencyMatrixGraphTest {

    CustomGraph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new CustomAdjacencyMatrixGraph<>();
        prepareSampleGraph();
    }

    @Test
    public void insertVertex() {
        graph.insertVertex("X");
        assertEquals("", graph.printAdjacentNode("X"));

        graph.insertEdge("X", "F");
        assertEquals("F", graph.printAdjacentNode("X"));
        assertEquals("B X", graph.printAdjacentNode("F"));
    }

    @Test
    public void insertEdge() {
        graph.insertVertex("N");
        assertEquals("", graph.printAdjacentNode("N"));

        graph.insertEdge("N", "A");
        assertEquals("A", graph.printAdjacentNode("N"));
        assertEquals("B C D N", graph.printAdjacentNode("A"));
    }

    @Test
    public void printAdjacentNode() {
        assertEquals("A E F", graph.printAdjacentNode("B"));
    }

    private void prepareSampleGraph() {
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertVertex("G");

        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("A", "D");
        graph.insertEdge("B", "E");
        graph.insertEdge("B", "F");
        graph.insertEdge("C", "G");
    }
}
