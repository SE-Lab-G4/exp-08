package org.example.graphTravelers.jgrapht;

import org.example.graphTravelers.Traverser;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class DfsGraphTraverserJGraphT implements Traverser {
    private final Graph<Integer, DefaultEdge> graph;

    public DfsGraphTraverserJGraphT(Graph<Integer, DefaultEdge> graph) {
        this.graph = graph;
    }

    @Override
    public List<Integer> traverse(Integer startVertex) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                result.add(vertex);

                List<Integer> neighbors = new ArrayList<>();
                for (DefaultEdge edge : graph.edgesOf(vertex)) {
                    Integer neighbor = graph.getEdgeSource(edge).equals(vertex)
                            ? graph.getEdgeTarget(edge)
                            : graph.getEdgeSource(edge);
                    neighbors.add(neighbor);
                }

                neighbors.sort(Collections.reverseOrder()); // reverse DFS order
                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result;
    }
}
