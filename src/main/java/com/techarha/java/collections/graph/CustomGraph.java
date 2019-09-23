package com.techarha.java.collections.graph;

public interface CustomGraph<T> {
    void insertVertex(T vertex) ;
    void insertEdge(T startVertex, T endVertex);
    String printAdjacentNode(T vertex) ;
}
