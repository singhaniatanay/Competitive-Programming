import java.util.ArrayList;
import java.util.Scanner;

public class D24_Coin_Change_Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println(CoinChangePermutations(coins, sc.nextInt()));
    }
    public static int CoinChangePermutations(int[] coins, int target) {
        int[] dp = new int[target + 1];
        ArrayList<String>[] paths = new ArrayList[dp.length];
        dp[0] = 1;
        ArrayList<String> empty = new ArrayList<>();
        empty.add("");
        paths[0] = empty;

        for (int i = 1; i < dp.length; i++) {
            for (int denomination : coins) {
                if(i-denomination<0)
                    continue;
                dp[i] += dp[i - denomination];
                ArrayList<String> prev = paths[i - denomination];
                ArrayList<String> curr = paths[i];
                if (curr == null) {
                    curr = new ArrayList<>();

                }
                if (prev == null) {
                    prev = new ArrayList<>();

                }
                for (int j = 0; j < prev.size(); j++) {
                    String s = prev.get(j);
                    s += denomination + "->";
                    curr.add(s);
                }
                paths[i] = curr;

            }
        }
        ArrayList<String> pathNeeded = paths[target];
        for (String s : pathNeeded) {
            System.out.println(s);
        }
        return dp[target];

    }
}
