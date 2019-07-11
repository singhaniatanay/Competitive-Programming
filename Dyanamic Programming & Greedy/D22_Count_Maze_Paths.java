import java.util.Scanner;

public class D22_Count_Maze_Paths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int srcRow = sc.nextInt();
        int srcCol = sc.nextInt();
        int dest = sc.nextInt();
        System.out.println(countMazePathMemoization(srcCol,srcRow,dest,dest,new int[dest+1][dest+1]));
        System.out.println(countMazePathTabulation(srcCol,srcRow,dest,dest));
    }
    public static int countMazePathMemoization(int srcCol,int srcRow,int destRow,int destCol,int[][] dp){
        if(srcCol==destCol && srcRow==destCol)
            return 1;
        if(srcCol>destCol || srcRow>destRow){
            return 0;
        }
        if(dp[srcRow][srcCol]!=0){
            return dp[srcRow][srcCol];
        }
        int countHorizontal = countMazePathMemoization(srcCol+1,srcRow,destRow,destCol,dp);
        int countVertical = countMazePathMemoization(srcCol,srcRow+1,destRow,destCol,dp);
        dp[srcRow][srcCol] = countHorizontal+countVertical;
        return dp[srcRow][srcCol];
    }
    public static int countMazePathTabulation(int srcCol,int srcRow,int destRow,int destCol){
        int[][] dp = new int[destRow+1][destCol+1];
        dp[destRow][destCol] =1;
        for (int i = dp.length-1; i>=0 ; i--) {
            dp[i][dp[0].length-1] = 1;
        }
        for (int i = dp[0].length-1; i>=0 ; i--) {
            dp[dp.length-1][i] = 1;
        }
        dp[destRow][destCol] =0;
        for (int i = destRow-1; i>=srcRow ; i--) {
            for (int j = destCol-1; j>=srcCol ; j--) {
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        if(srcCol>destCol || srcRow>destRow){
            return 0;
        }
        return dp[srcRow][srcCol];
    }
}
