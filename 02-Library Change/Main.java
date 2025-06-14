package org.example;

import org.example.adapter.JGraphTGraphAdapter;

public class Main {
    public static void main(String[] args) {
        JGraphTGraphAdapter adapter = new JGraphTGraphAdapter();

        System.out.println("JGraphT DFS from node 1: " + adapter.traverseDFS(1));
        System.out.println("JGraphT BFS from node 1: " + adapter.traverseBFS(1));
    }
}
