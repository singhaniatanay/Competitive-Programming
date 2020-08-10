import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class evenForest {

    // Complete the evenForest function below.
    static int evenForestfunc(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
            ArrayList<Integer>[] graph = new ArrayList[t_nodes];
            for(int i=0;i<t_nodes;i++) graph[i] = new ArrayList<Integer>();
            for(int i=0;i<t_edges;i++){
                graph[t_from.get(i)-1].add(t_to.get(i)-1);
                graph[t_to.get(i)-1].add(t_from.get(i)-1);
            }
            count = 0;
            visited = new boolean[t_nodes];
            for(int i=0;i<t_nodes;i++){
                if(visited[i]) continue;
                breakTree(graph,i);
            }
            return count;

    }
    public static int breakTree(ArrayList<Integer>[] graph,int src){
        if(visited[src]) return 0;
        int ans = 0;
        visited[src] = true;
        for(int i:graph[src]){
            if(visited[i]) continue;
            int currAns = breakTree(graph,i);
            if(currAns%2==0) count++;
            ans+=currAns;
        }
        return ans+1;

    }
    public static boolean[] visited;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = evenForestfunc(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
