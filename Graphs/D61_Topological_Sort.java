import java.util.LinkedList;
import java.util.Stack;

public class D61_Topological_Sort {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(4,1);
        graph.addEdge(4,3);
        graph.addEdge(3,1);
        graph.addEdge(3,2);
        graph.addEdge(1,2);
        graph.printGraph();
        //though pointless here since while adding edge
        //it makes undirected graph in which topological sort
        //is DFS only
        String ans = topologicalSort(graph);
        System.out.println(ans);
    }
    public static String topologicalSort(Graph graph){
        boolean[] visited = new boolean[graph.V];
        topoSort = new Stack<>();
        for (int i = 0; i <graph.V ; i++) {
            if(!visited[i]){
                topologicalSortUtil(graph,visited,i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!topoSort.isEmpty()){
            sb.append(topoSort.pop());
            if(!topoSort.isEmpty())
                sb.append(", ");
        }
        return sb.toString();

    }
    public static Stack<Integer> topoSort;
    private static void topologicalSortUtil(Graph graph, boolean[] visited, int i) {
        visited[i] = true;
        LinkedList<Integer> adj = graph.list.get(i);
        for (int ele:adj){
            if (!visited[ele]){
                topologicalSortUtil(graph, visited, ele);
            }
        }
        topoSort.push(i);
    }
}
