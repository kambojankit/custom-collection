package com.techarha.java.collections.graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

//TODO: Implementation For Adjacency Matrix Graph
public class CustomAdjacencyMatrixGraph<T> implements CustomGraph<T> {

    Boolean[][] matrix;
    private static final int INITIAL_CAPACITY = 5;
    private int currentCapacity = INITIAL_CAPACITY;
    private Map<T, Integer> map;
    private Integer size = 0;

    public CustomAdjacencyMatrixGraph() {
        this(INITIAL_CAPACITY);
    }

    public CustomAdjacencyMatrixGraph(int vertexCount) {
        this.matrix = (Boolean[][]) Array.newInstance(Boolean.class, vertexCount, vertexCount);
        map = new HashMap<>();
    }

    @Override
    public void insertVertex(T vertex) {
        if(isFull()) resizeMatrix();

        if(isVertexPresent(vertex)) return;

        map.put(vertex, size++);
    }

    @Override
    public void insertEdge(T startVertex, T endVertex) {
        if(!isVertexPresent(startVertex) || !isVertexPresent(endVertex)) return;

        int startIndex = getIndexForVertex(startVertex);
        int endIndex = getIndexForVertex(endVertex);

        matrix[startIndex][endIndex] = true;
        matrix[endIndex][startIndex] = true;
    }

    @Override
    public String printAdjacentNode(T vertex) {
        if(!isVertexPresent(vertex)) return "";

        StringBuffer buffer = new StringBuffer();

        int startIndex = getIndexForVertex(vertex);
        Boolean[] edges = matrix[startIndex];

        for(int i = 0; i < edges.length; i++) {
            if(!isNull(edges[i]) && edges[i])
                buffer.append(getVertexFor(i) + " ");
        }

        if(buffer.length() >  0) buffer.deleteCharAt(buffer.lastIndexOf(" "));
        return buffer.toString();
    }

    private T getVertexFor(Integer data) {
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(data)) {
                return entry.getKey();
            }

        }
        return null;
    }

    private int getIndexForVertex(T vertex) {
        if(!map.containsKey(vertex)) return -1;

        return map.get(vertex);
    }

    private boolean isVertexPresent(T vertex) {
        return getIndexForVertex(vertex) != -1;
    }

    private boolean isFull() {
        return size == currentCapacity - 1;
    }


    private void resizeMatrix() {
        int newCapacity = currentCapacity * 2;
        Boolean[][] result = (Boolean[][]) Array.newInstance(Boolean.class, newCapacity, newCapacity);

        for (int i = 0; i < matrix.length; i++) {
            result[i] = Arrays.copyOf(matrix[i], newCapacity);
        }

        matrix = result;
        currentCapacity = newCapacity;
    }
}
