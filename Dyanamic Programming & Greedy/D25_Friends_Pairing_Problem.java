import java.util.Scanner;

public class D25_Friends_Pairing_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(paringProb(n));
    }
    public static int paringProb(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; //ek tarika koi bhi nahi
        dp[1] = 1; // ek tarika for one to be that is single
        for (int i = 2; i < dp.length; i++) {
            dp[i] =  dp[i-1]+(dp[i-2]*(i-1));
        }
        return dp[n];
    }
}
