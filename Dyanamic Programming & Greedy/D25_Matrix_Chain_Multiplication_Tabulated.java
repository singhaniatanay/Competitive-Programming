import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D25_Matrix_Chain_Multiplication_Tabulated {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String[] vals = br.readLine().split(" ");
        int[] arr = new int[vals.length];
        for (int i = 0; i <vals.length ; i++) {
            arr[i] = Integer.parseInt(vals[i]);
        }
        pw.println(matrixChainMultcostTabulated(arr));
        pw.flush();
    }
    private static int matrixChainMultcostTabulated(int[] dims){
        int[][] dp = new int[dims.length][dims.length];
        if(dp.length==0)
            return 0;

        for (int gap=1;gap<dp.length;gap++){
            for (int i = 0,j=i+gap; j<dp.length; i++,j++) {
                int cost = Integer.MAX_VALUE;
                if(gap==1) {
                    dp[i][j] = 0;
                    continue;
                }
                for (int cutPt = i+1; cutPt <j ; cutPt++) {
                    int fP = dp[i][cutPt];
                    int sP = dp[cutPt][j];
                    int currCost = dims[i]*dims[cutPt]*dims[j];
                    cost = Math.min(cost,fP+sP+currCost);
                }
                dp[i][j] = cost;
            }
        }
        return dp[0][dp.length-1];
    }
}
