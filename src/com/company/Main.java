package com.company;

import com.company.graph.oriented.noweight.Graph;

public class Main {

    public static void main(String[] args) {
	    Graph graph = createGraph();
        System.out.println(graph);
    }

    static Graph createGraph() {

        Graph graph = new Graph();

        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        return graph;
    }
}
