package com.techarha.java.collections.graph;

import java.util.*;

//TODO: Implementation For Adjacency List Graph
public class CustomAdjacencyListGraph<T extends Comparable<T>> implements CustomGraph<T> {
    Map<T, LinkedList<T>> adjacencyList;

    public CustomAdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public void insertVertex(T vertex) {
        if(!isVertexPresent(vertex)) {
            adjacencyList.put(vertex, new LinkedList<>());
        }
    }

    @Override
    public void insertEdge(T startVertex, T endVertex) {
        if(isVertexPresent(startVertex) && isVertexPresent(endVertex)) {
            LinkedList<T> srcEdges = adjacencyList.get(startVertex);
            if(!srcEdges.contains(endVertex)) {
                srcEdges.add(endVertex);
            }

            LinkedList<T> destEdges = adjacencyList.get(endVertex);
            if(!destEdges.contains(startVertex)) {
                destEdges.add(startVertex);
            }
        }
    }


    public String dfsTraversal() {
        if(adjacencyList.isEmpty()) return "";
        T firstElement = adjacencyList.keySet().iterator().next();
        StringBuffer buffer = new StringBuffer();
        dfsTraversal(firstElement, buffer, new HashSet<>());

        return buffer.toString();
    }

    private void dfsTraversal(T root, StringBuffer buff, Set<T> set) {
        if(!isVertexPresent(root) || set.contains(root)) return;

        set.add(root);

        buff.append(root + " ");

        LinkedList<T> children = adjacencyList.get(root);
        for (T child : children) {
            dfsTraversal(child, buff, set);
        }
    }


    @Override
    public String printAdjacentNode(T vertex) {
        if(isVertexPresent(vertex)) {
            StringBuffer buffer = new StringBuffer();

            LinkedList<T> edgeList = adjacencyList.get(vertex);
            edgeList.forEach(v -> buffer.append(v + " "));

            if(buffer.length() > 0)
                buffer.deleteCharAt(buffer.lastIndexOf(" "));

            return buffer.toString();
        }
        return "";
    }

    private boolean isVertexPresent(T vertex) {
        return adjacencyList.containsKey(vertex);
    }
}
