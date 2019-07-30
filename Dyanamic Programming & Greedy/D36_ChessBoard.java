import java.util.*;
import java.lang.*;
import java.io.*;
/*
Find total number of Squares in a N*N cheesboard.

Input:

The first line contains an integer T, depicting total
number of test cases. Then following T lines contains
an integer N that is the side of the chessboard.

Output:

Each seperate line showing the maximum number of squares possible.
*/

class D36_ChessBoard {
    public static void main (String[] args) throws IOException{
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int ans = chessboard(n);
            pw.println(ans);
        }
        pw.flush();
    }
    public static int chessboard(int n){
        int[][] dp = new int[n][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp.length-2;j>=0;j--){
                dp[i][j] = Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]))+1;
            }
        }
        int sum=0;
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp.length-1;j>=0;j--){
                sum+= dp[i][j];
            }
        }
        return sum;

    }
}
