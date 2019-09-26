package com.techarha.java.collections.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomAdjacencyListGraphTest {

    CustomAdjacencyListGraph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new CustomAdjacencyListGraph<>();
        prepareSampleGraph();
    }

    @Test
    public void insertVertex() {
        graph.insertVertex("J");
        assertEquals("", graph.printAdjacentNode("J"));

        graph.insertEdge("J", "F");
        assertEquals("F", graph.printAdjacentNode("J"));
        assertEquals("B H J", graph.printAdjacentNode("F"));
    }


    @Test
    public void insertEdge() {
        graph.insertVertex("L");
        assertEquals("", graph.printAdjacentNode("L"));

        graph.insertEdge("L", "A");
        assertEquals("A", graph.printAdjacentNode("L"));
        assertEquals("B C D I L", graph.printAdjacentNode("A"));
    }

    @Test
    public void printAdjacentNode() {
        assertEquals("D E F G", graph.printAdjacentNode("H"));
    }

    @Test
    public void dfsTraversal() {
        System.out.println(graph.dfsTraversal());
    }

    private void prepareSampleGraph() {
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertVertex("G");
        graph.insertVertex("H");
        graph.insertVertex("I");
        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("A", "D");
        graph.insertEdge("B", "E");
        graph.insertEdge("B", "F");
        graph.insertEdge("C", "G");
        graph.insertEdge("D", "H");
        graph.insertEdge("E", "H");
        graph.insertEdge("F", "H");
        graph.insertEdge("G", "H");
        graph.insertEdge("A", "I");

    }
}
