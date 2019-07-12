import java.util.Scanner;

public class D24_Rod_Cutting_Memoized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n];
        for (int i = 0; i <profit.length ; i++) {
            profit[i] = sc.nextInt();
        }
        System.out.println(RodCutMemoized(profit,new int[profit.length],profit.length-1));
    }
    public static int RodCutMemoized(int[] profits,int[] dp,int point){
        if(point==0){
            return profits[0];
        }
        if(dp[point]!=0)
            return dp[point];

        int st = 0;
        int end  =point-1;
        int currAns=Integer.MIN_VALUE;
        while (st<=end){
            currAns = Math.max(RodCutMemoized(profits,dp,st)+RodCutMemoized(profits, dp, end),currAns);
            st++;
            end--;
        }
        dp[point] = Math.max(currAns,profits[point]);
        return dp[point];
    }
}
