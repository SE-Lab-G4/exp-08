package org.example.graphTravelers.jgrapht;

import org.example.graphTravelers.Traverser;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class BfsGraphTraverserJGraphT implements Traverser {
    private final Graph<Integer, DefaultEdge> graph;

    public BfsGraphTraverserJGraphT(Graph<Integer, DefaultEdge> graph) {
        this.graph = graph;
    }

    @Override
    public List<Integer> traverse(Integer startVertex) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.add(vertex);

            List<Integer> neighbors = new ArrayList<>();
            for (DefaultEdge edge : graph.edgesOf(vertex)) {
                Integer neighbor = graph.getEdgeSource(edge).equals(vertex)
                        ? graph.getEdgeTarget(edge)
                        : graph.getEdgeSource(edge);
                neighbors.add(neighbor);
            }

            neighbors.sort(Comparator.naturalOrder());
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
}
