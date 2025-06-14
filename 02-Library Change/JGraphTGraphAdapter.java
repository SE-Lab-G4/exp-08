package org.example.adapter;

import org.example.graphTravelers.Traverser;
import org.example.graphTravelers.jgrapht.DfsGraphTraverserJGraphT;
import org.example.graphTravelers.jgrapht.BfsGraphTraverserJGraphT;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.List;

public class JGraphTGraphAdapter {

    private final Graph<Integer, DefaultEdge> graph;

    public JGraphTGraphAdapter() {
        graph = new SimpleGraph<>(DefaultEdge.class);

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
    }

    public List<Integer> traverseDFS(int startVertex) {
        Traverser dfs = new DfsGraphTraverserJGraphT(graph);
        return dfs.traverse(startVertex);
    }

    public List<Integer> traverseBFS(int startVertex) {
        Traverser bfs = new BfsGraphTraverserJGraphT(graph);
        return bfs.traverse(startVertex);
    }
}
