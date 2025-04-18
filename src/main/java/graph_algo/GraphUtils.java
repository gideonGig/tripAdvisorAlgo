package graph_algo;

public class GraphUtils {

    public static void searchGraph(Graph graph, Integer s) {
        Integer count = 0;
        boolean[] marked = new boolean[graph.getVertex()];
        count = depthFirstSearch(graph, s, marked);
        System.out.println(count);
    }

    public static Integer depthFirstSearch(Graph graph, Integer s, boolean[] marked) {
        marked[s] = true;
        int count = 1;
        for (Integer v : graph.getAdj(s)) {
            if (!marked[v]) {
                count += depthFirstSearch(graph, v, marked);
            }
        }
        return count;
    }
}
