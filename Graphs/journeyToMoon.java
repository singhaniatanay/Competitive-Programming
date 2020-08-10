import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class journeyToMoon {

    // Complete the journeyToMoon function below.
    static long journeytoMoon(int n, int[][] ast) {
        if(n<=1) return 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<Integer>());
        for(int i=0;i<ast.length;i++){
            graph.get(ast[i][0]).add(ast[i][1]);
            graph.get(ast[i][1]).add(ast[i][0]);
        }
        visited = new boolean[n];
        long ans = 0;
        long sum =0;
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            long curr = getConnected(graph,i);
            ans += (sum)*curr;
            sum += curr;
        }
        return ans;

    }
    public static long getConnected(ArrayList<ArrayList<Integer>> graph, int src){
        if(visited[src]) return 0;
        long ans = 0;
        visited[src] = true;
        for(int nbr: graph.get(src)){
            if(visited[nbr]) continue;
            ans += getConnected(graph,nbr);
        }
        return ans+1;
    }
    public static boolean[] visited;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeytoMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
