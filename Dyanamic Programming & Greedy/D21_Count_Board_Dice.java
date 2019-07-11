import java.util.Scanner;
/*
     QUESTION :

 */
public class D21_Count_Board_Dice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(countBoardMemoization(s,d,new int[d+1]));
        System.out.println(countBoardTabulatoin(s,d));
    }
    public static int countBoardMemoization(int source,int dest,int[] dp){
        if(source>dest){
            return 0;
        }
        if(source==dest){
            return 1;
        }
        if(dp[source]!=0){
            return dp[source];
        }
        int countSourcetoDest=0;
        for (int dice = 1; dice <=6 ; dice++) {
            int future = source+dice;
            int countFuturetoDest = countBoardMemoization(future,dest,dp);
            countSourcetoDest+=countFuturetoDest;
        }
        dp[source] = countSourcetoDest;
        return countSourcetoDest;
    }
    public static int countBoardTabulatoin(int source,int dest){
        if(source>dest)
            return 0;
        int[] dp = new int[dest+1];
        dp[dest] = 1;
        for (int i = dest-1; i>=source ; i--) {
            for (int dice = 1; dice <=6 ; dice++) {
                int future = i+dice;
                if(future<=dest){
                    dp[i] += dp[future];
                }
            }
        }
        return dp[source];
    }
}
