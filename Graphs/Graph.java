import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
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
}
