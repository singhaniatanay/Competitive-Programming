import java.util.Arrays;
import java.util.Scanner;

public class D23_Palindrome_Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(CountPalindromeSubstring(str));
    }
    public static int CountPalindromeSubstring(String str){
        boolean[][] dp = new boolean[str.length()][str.length()];
        int count=0;
        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=i+gap;j<dp[0].length;i++,j++){
                // i to j substring
                if(i==j){
                    dp[i][j]=true;
                    count++;
                    continue;
                }else if(j-i+1==2){
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }
                    continue;
                }
                if(str.charAt(i)==str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j])
                        count++;
                }
            }
        }
        return count;
    }
}
