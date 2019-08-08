import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class D60_DFS {
    static class Graph{
        int V;
        ArrayList<LinkedList<Integer>> list;
        Graph(int V){
            this.V = V;
            list = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                list.add(new LinkedList<Integer>());
            }
        }
        void addEdge(int src,int dest){
            LinkedList<Integer> s = list.get(src);
            s.add(dest);
            LinkedList<Integer> d = list.get(dest);
            d.add(src);
        }
        void printGraph(){
            for (int i = 0; i <V ; i++) {
                System.out.print("Adjacency List of "+i+" : ");
                LinkedList<Integer> ll = list.get(i);
                for (Integer curr:ll){
                    System.out.print(curr+", ");
                }
                System.out.println();
            }
        }
        void BFS(int root){
            boolean[] visited = new boolean[list.size()];
            Queue<Integer> q = new LinkedList<>();

            visited[root] = true;
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Integer curr = q.remove();
                if(curr==null){
                    System.out.println();
                    if(!q.isEmpty()){
                        q.add(null);
                    }
                    continue;
                }
                System.out.print(curr+", ");
                LinkedList<Integer> adj = list.get(curr);
                for(Integer connected : adj){
                    if(!visited[connected]){
                        visited[connected] = true;
                        q.add(connected);
                    }
                }
            }
        }
        void DFSUtil(int v,boolean[] visited){
            visited[v] = true;
            System.out.println(v);
            LinkedList<Integer> ll = list.get(v);
            for (int i:ll){
                if(!visited[i]){
                    DFSUtil(i,visited);
                }
            }
        }
        void DFS(int root){
            boolean[] visited = new boolean[V];
            DFSUtil(root,visited);
        }

    }
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
        graph.BFS(0);
        graph.DFS(0);
    }
}
