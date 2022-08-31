package com.company.graph.oriented.weight;

public class Edge {

    Vertex vertexTo;
    Long weight;

    Edge(Vertex vertexTo, Long weight) {

        this.vertexTo = vertexTo;
        this.weight = weight;
    }

    Edge(Vertex vertexTo) {

        this.vertexTo = vertexTo;
        this.weight = 0L;
    }
}
