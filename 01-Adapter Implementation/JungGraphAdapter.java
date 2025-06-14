package org.example.adapter;

import edu.uci.ics.jung.graph.SparseMultigraph;
import org.example.graphTravelers.BfsGraphTraverser;
import org.example.graphTravelers.DfsGraphTraverser;
import org.example.graphTravelers.Traverser;

import java.util.List;

public class JungGraphAdapter {

    private final SparseMultigraph<Integer, String> graph;

    public JungGraphAdapter() {

        graph = new SparseMultigraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge("E1", 1, 2);
        graph.addEdge("E2", 1, 3);
        graph.addEdge("E3", 2, 4);
        graph.addEdge("E4", 3, 5);
        graph.addEdge("E5", 4, 5);
    }

    public List<Integer> traverseDFS(int startVertex) {
        Traverser dfs = new DfsGraphTraverser(graph);
        return dfs.traverse(startVertex);
    }

    public List<Integer> traverseBFS(int startVertex) {
        Traverser bfs = new BfsGraphTraverser(graph);
        return bfs.traverse(startVertex);
    }
}
