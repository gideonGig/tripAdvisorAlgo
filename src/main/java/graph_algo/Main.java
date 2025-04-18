package graph_algo;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);
        graph.addEdge(0, 2);

        GraphUtils.searchGraph(graph, 0);
    }
}
