package com.company.graph.oriented.noweight;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


// No weight graph
// todo Add weights
// Я могу хранить пути непосредственно в вершине
public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        adjVertices = new LinkedHashMap<>();
    }

    public void addVertex(String label) {

        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }


    public void removeVertex(String label) {

        Vertex v = new Vertex(label);

        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }


    public void addEdge(String label1, String label2) {

        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }


    public void removeEdge(String label1, String label2) {

        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);

        if (eV1 != null)
            eV1.remove(v2);

        if (eV2 != null)
            eV2.remove(v1);
    }
}
