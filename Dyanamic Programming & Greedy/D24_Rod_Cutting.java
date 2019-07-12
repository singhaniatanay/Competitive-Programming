import java.util.Scanner;

public class D24_Rod_Cutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n];
        for (int i = 0; i <profit.length ; i++) {
            profit[i] = sc.nextInt();
        }
        System.out.println(RodCut(profit));
    }
    public static int RodCut(int[] profit){
        int[] dp = new int[profit.length];
        for (int i = 0; i < dp.length; i++) {
            int profitIfNotCut = profit[i];
            int st=0;
            int end = i-1;
            int profitIfCut = Integer.MIN_VALUE;
            while (st<= end){
                profitIfCut = Math.max(dp[st]+dp[end],profitIfCut);
                st++;
                end--;
            }
            dp[i] = Math.max(profitIfCut,profitIfNotCut);
        }
        return dp[dp.length-1];
    }
}
