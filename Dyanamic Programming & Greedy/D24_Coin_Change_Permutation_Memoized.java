import java.util.ArrayList;
import java.util.Scanner;

public class D24_Coin_Change_Permutation_Memoized {
    static int globalTarget=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        globalTarget=target;
        ArrayList<String> ans = CoinChangePermutations(coins,target ,new int[target+1],new ArrayList[target+1]);
        System.out.println(ans);
        System.out.println(ans.size());
    }
    public static ArrayList<String> CoinChangePermutations(int[] coins, int target,int[] dp,ArrayList<String>[] DPpaths){
        if(target<0){
            ArrayList<String> ans = new ArrayList<String>();
            return ans;
        }
        if(target==0) {
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }
        if(DPpaths[target]!=null) {
            return DPpaths[target];
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int denomination : coins) {
                if(target-denomination<0)
                    continue;
                ArrayList<String> curr = CoinChangePermutations(coins, target-denomination, dp,DPpaths);
                for (int j = 0; j < curr.size(); j++) {
                    String s = curr.get(j);
                    s += denomination + "->";
                    ans.add(s);
                }
            }
        DPpaths[target] = ans;
        return DPpaths[target];
    }
}
