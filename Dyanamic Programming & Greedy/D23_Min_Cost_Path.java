import java.util.Scanner;
public class D23_Min_Cost_Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(minCostPathMemoization(mat,0,0,mat.length-1,mat[0].length-1,new int[mat.length][mat[0].length]));
        System.out.println(minCostPathTabulation(mat,0,0,mat.length-1,mat[0].length-1));
        int[][] table = minCostPathTable(mat, 0, 0, mat.length-1,mat[0].length-1);
        minCostPath(mat,table,0, 0, mat.length-1,mat[0].length-1,"");

    }
    public static int minCostPathMemoization(int[][] costs, int sr,int sc,int dr,int dc,int[][] dp){
        if(sr>dr || sc>dc){
            return Integer.MAX_VALUE;
        }
        if(sr==dr && sc==dc)
            return costs[sr][sc];
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int costHorizontal = minCostPathMemoization(costs,sr,sc+1,dr,dc,dp);
        int costVertical = minCostPathMemoization(costs,sr+1,sc,dr,dc,dp);
        dp[sr][sc] = Math.min(costHorizontal,costVertical)+costs[sr][sc];
        return dp[sr][sc];
    }
    public static int minCostPathTabulation(int[][] costs, int sr,int sc,int dr,int dc){
        if(sr>dr || sc>dc){
            return Integer.MAX_VALUE;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        //dp[dr][dc] = costs[dr][dc];
        int prevCosts=0;
        for (int i = dp.length-1; i>=0 ; i--) {
            dp[i][dp[0].length-1] = costs[i][dp[0].length-1]+prevCosts;
            prevCosts +=costs[i][dp[0].length-1];
        }
        prevCosts=0;
        for (int i = dp[0].length-1; i>=0 ; i--) {
            dp[dp.length-1][i] = costs[dp.length-1][i]+prevCosts;
            prevCosts +=costs[dp.length-1][i];
        }
        for (int i = dp.length-2;i>=0; i--) {
            for (int j = dp[0].length-2; j>=0 ; j--) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+costs[i][j];
            }
        }
        return dp[sr][sc];
    }
    public static int[][] minCostPathTable(int[][] costs, int sr,int sc,int dr,int dc){
        if(sr>dr || sc>dc){
            return null;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        //dp[dr][dc] = costs[dr][dc];
        int prevCosts=0;
        for (int i = dp.length-1; i>=0 ; i--) {
            dp[i][dp[0].length-1] = costs[i][dp[0].length-1]+prevCosts;
            prevCosts +=costs[i][dp[0].length-1];
        }
        prevCosts=0;
        for (int i = dp[0].length-1; i>=0 ; i--) {
            dp[dp.length-1][i] = costs[dp.length-1][i]+prevCosts;
            prevCosts +=costs[dp.length-1][i];
        }
        for (int i = dp.length-2;i>=0; i--) {
            for (int j = dp[0].length-2; j>=0 ; j--) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+costs[i][j];
            }
        }
        return dp;
    }
    public static void minCostPath(int[][] costs,int[][] dp,int sr,int sc,int dr,int dc,String path){
        if(sc==dc && sr==dr) {
            System.out.println(path + "" + costs[sr][sc]);
            return;
        }
        if(sc>dc || sr>dr)
            return;

        int right = sc+1<dp[0].length?dp[sr][sc+1]:Integer.MAX_VALUE;
        int down = sr+1<dp.length?dp[sr+1][sc]:Integer.MAX_VALUE;
        int min = Math.min(right,down);
        if(min==right){
            minCostPath(costs, dp, sr, sc+1, dr, dc, path+costs[sr][sc]+"->");
        }
        if(min==down){
            minCostPath(costs, dp, sr+1, sc, dr, dc, path+costs[sr][sc]+"->");
        }

    }
}
