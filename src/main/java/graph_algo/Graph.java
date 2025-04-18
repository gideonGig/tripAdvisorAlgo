package graph_algo;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v1, int v2) {
        adj[v1].add(v2);
        adj[v2].add(v1);
        E++;
    }

    public Integer getVertex() {
        return V;
    }

    public Integer getEdge() {
        return E;
    }

    public Iterable<Integer> getAdj(int v) {
        return adj[v];
    }
}
