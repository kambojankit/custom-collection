package com.techarha.java.collections.graph;

import java.util.*;

import static java.util.Objects.isNull;

//TODO: Implementation For Adjacency List Graph
public class CustomBetterGraph<T extends Comparable<T>> implements CustomGraph<T> {
    Map<T, GraphNode<T>> nodeLookup;

    public CustomBetterGraph() {
        this.nodeLookup = new HashMap<>();
    }


    @Override
    public void insertVertex(T vertex) {
        if(!nodeLookup.containsKey(vertex)) {
            GraphNode<T> node = new GraphNode<>(vertex);
            nodeLookup.put(vertex, node);
        }
    }

    @Override
    public void insertEdge(T startVertex, T endVertex) {
        addEdge(startVertex, endVertex);
    }

    @Override
    public String printAdjacentNode(T vertex) {
        if(nodeLookup.containsKey(vertex)) {
            StringBuffer buffer = new StringBuffer();

            getNode(vertex).adjacent.forEach(v -> buffer.append(v + " "));

            if(buffer.length() > 0)
                buffer.deleteCharAt(buffer.lastIndexOf(" "));

            return buffer.toString();
        }
        return "";
    }


    private GraphNode getNode(T data) {
        return nodeLookup.get(data);
    }

    private void addEdge(T source, T destination) {
        GraphNode<T> s = getNode(source);
        GraphNode<T> d = getNode(destination);

        s.adjacent.add(d);
    }


    public boolean hasPathDFS(T source, T destination) {
        GraphNode<T> s = getNode(source);
        GraphNode<T> d = getNode(destination);

        HashSet<GraphNode<T>> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(GraphNode<T> s, GraphNode<T> d, HashSet<GraphNode<T>> visited) {
        if(isNull(s) || isNull(d)) return false;
        if(visited.contains(s)) return false;

        visited.add(s);

        if(s.equals(d)) return true;

        for (GraphNode child : s.adjacent) {
            if(hasPathDFS(child, d, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPathBFS(T source, T destination) {
        GraphNode<T> s = getNode(source);
        GraphNode<T> d = getNode(destination);

        Queue<GraphNode<T>> queue = new LinkedList<>();
        return hasPathBFS(s, d, queue);
    }

    private boolean hasPathBFS(GraphNode<T> source, GraphNode<T> destination, Queue<GraphNode<T>> queue) {
        if(isNull(source) || isNull(destination)) return false;
        queue.add(source);
        HashSet<GraphNode<T>> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            GraphNode<T> current = queue.poll();
            visited.add(current);

            if(current.equals(destination)) return true;

            current.adjacent.stream()
                .filter(node -> !visited.contains(node))
                .forEach(node -> queue.add(node));
        }
        return false;
    }

    public static class GraphNode<T> {
        private T data;
        LinkedList<GraphNode<T>> adjacent = new LinkedList<>();

        public GraphNode(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GraphNode)) return false;
            GraphNode<?> graphNode = (GraphNode<?>) o;
            return Objects.equals(data, graphNode.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
}
