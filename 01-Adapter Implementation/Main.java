package org.example;

import org.example.adapter.JungGraphAdapter;

public class Main {
    public static void main(String[] args) {
        JungGraphAdapter adapter = new JungGraphAdapter();

        System.out.println("JUNG DFS from node 1: " + adapter.traverseDFS(1));
        System.out.println("JUNG BFS from node 1: " + adapter.traverseBFS(1));
    }
}
