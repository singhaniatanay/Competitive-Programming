import java.util.ArrayList;
import java.util.LinkedList;

public class D60_Representation {
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
    }
}



