package graph_algo;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int numOfVertex;

    private int edge;

    private final List<Integer>[] adjList;

    public Graph(int numberOfVertex) {
        numOfVertex = numberOfVertex;
        adjList = new ArrayList[numOfVertex];
        for (int i = 0; i < numOfVertex; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
        edge++;
    }

    public Integer getNumOfVertex() {
        return numOfVertex;
    }

    public Integer getEdge() {
        return edge;
    }

    public Iterable<Integer> getAdj(int v) {
        return adjList[v];
    }

    public boolean isConnected(int v1, int v2) {
        if (v1 < 0 || v1 > numOfVertex) {
            return false;
        }
        List<Integer> neighbours = adjList[v1];
        for (int num : neighbours) {
            if (num == v2) {
                return true;
            }
        }

        return false;
    }
}
