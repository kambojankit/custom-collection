package com.techarha.java.collections.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomEdgeListGraphTest {

    CustomGraph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new CustomEdgeListGraph<>(String.class);
        prepareSampleGraph();
    }

    @Test
    public void insertVertex() {
        graph.insertVertex("I");
        assertEquals("", graph.printAdjacentNode("I"));

        graph.insertEdge("I", "F");
        assertEquals("F", graph.printAdjacentNode("I"));
        assertEquals("B H I", graph.printAdjacentNode("F"));
    }

    @Test
    public void insertEdge() {
        graph.insertVertex("M");
        assertEquals("", graph.printAdjacentNode("M"));

        graph.insertEdge("M", "A");
        assertEquals("A", graph.printAdjacentNode("M"));
        assertEquals("B C D M", graph.printAdjacentNode("A"));
    }

    @Test
    public void printAdjacentNode() {
        assertEquals("D E F G", graph.printAdjacentNode("H"));
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

    }
}
