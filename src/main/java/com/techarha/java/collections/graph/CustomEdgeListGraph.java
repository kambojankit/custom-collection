package com.techarha.java.collections.graph;

import com.techarha.java.collections.list.CustomArrayList;
import com.techarha.java.collections.list.CustomList;

public class CustomEdgeListGraph<T> implements CustomGraph<T> {
    CustomList<T> vertexList;
    CustomList<CustomGraphEdge> edgeList;

    public CustomEdgeListGraph(Class<T> clazz) {
        vertexList = new CustomArrayList<>(clazz);
        edgeList = new CustomArrayList<>(CustomGraphEdge.class);
    }

    @Override
    public void insertVertex(T vertex) {
        if(!vertexList.contains(vertex))
           vertexList.addToEnd(vertex);
    }

    @Override
    public void insertEdge(T startVertex, T endVertex) {
        edgeList.addToEnd(new CustomGraphEdge(startVertex, endVertex));
    }

    @Override
    public String printAdjacentNode(T vertex) {
        if(!vertexList.contains(vertex)) return "";

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < edgeList.size(); i++) {
            CustomGraphEdge<T> edge = edgeList.get(i);

            if(edge.getStart().equals(vertex)) {
                buffer.append(edge.getEnd() + " ");
            }

            if(edge.getEnd().equals(vertex)) {
                buffer.append(edge.getStart() + " ");
            }
        }

        if(buffer.length() > 0)
            buffer.deleteCharAt(buffer.lastIndexOf(" "));

        return buffer.toString();
    }

    static class CustomGraphEdge<T> {
        T start;
        T end;
        int weight;

        public CustomGraphEdge(T start, T end) {
            this.start = start;
            this.end = end;
        }

        public CustomGraphEdge(T start, T end, int weight) {
            this(start, end);
            this.weight = weight;
        }

        public T getStart() {
            return start;
        }

        public void setStart(T start) {
            this.start = start;
        }

        public T getEnd() {
            return end;
        }

        public void setEnd(T end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
