package com.company.graph.oriented.weight;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


// No weight graph
// todo Add weights
// Я могу хранить пути непосредственно в вершине
public class Graph {

    private Map<Vertex, List<Edge>> adjVertices;

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


    public void addEdge(String label1, String label2, Long weight) {

        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjVertices.get(v2).add(new Edge(v1, weight));
    }

    public void addTwoEdgesSameWeight(String label1, String label2, Long weight) {

        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjVertices.get(v2).add(new Edge(v1, weight));
    }

    public void addTwoEdgesDiffWeight(String label1, String label2, Long weightV1V2, Long weightV2V1) {

        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjVertices.get(v1).add(new Edge(v2, weightV1V2));
        adjVertices.get(v2).add(new Edge(v1, weightV2V1));
    }


    //todo refactor, remake
    public void removeEdge(String label1, String label2) {

        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Edge> edgesV1 = adjVertices.get(v1);
        edgesV1.remove(edgesV1.stream().filter(edge -> edge.vertexTo.equals(v2)).findFirst().get());

        List<Edge> edgesV2 = adjVertices.get(v2);
        edgesV2.remove(edgesV2.stream().filter(edge -> edge.vertexTo.equals(v1)).findFirst().get());

//        List<Vertex> eV1 = adjVertices.get(v1);
//        List<Vertex> eV2 = adjVertices.get(v2);
//
//        if (eV1 != null)
//            eV1.remove(v2);
//
//        if (eV2 != null)
//            eV2.remove(v1);
    }
}
