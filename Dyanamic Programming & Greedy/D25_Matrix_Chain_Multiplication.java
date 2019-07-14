import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D25_Matrix_Chain_Multiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String[] vals = br.readLine().split(" ");
        int[] arr = new int[vals.length];
        for (int i = 0; i <vals.length ; i++) {
            arr[i] = Integer.parseInt(vals[i]);
        }
        pw.println(matrixMultCostMemoized(arr,0,arr.length-1,new int[arr.length][arr.length])+"");
        pw.flush();
    }
    private static int matrixMultCostMemoized(int[] arr,int st,int end,int[][] dp){
        if(end-st==1){
            return 0;
        }
        if(dp[st][end]!=0){
            return dp[st][end];
        }
        int minCost = Integer.MAX_VALUE;
        for (int cutPt= st+1; cutPt <end ; cutPt++) {
            int pehlaPartition = matrixMultCostMemoized(arr,st,cutPt,dp); // arr[st]*arr[cutpt] in size
            int dusraPartition = matrixMultCostMemoized(arr,cutPt,end,dp); // arr[cutpt]*arr[[end] in size
            int currcost = (arr[st]*arr[cutPt]*arr[end]);
            int cost = pehlaPartition+dusraPartition+currcost;
            minCost = Math.min(cost,minCost);
        }
        dp[st][end] = minCost;
        return minCost;
    }
}
