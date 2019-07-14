import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D25_Minimum_Palindromic_Cut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String input = br.readLine();
        pw.printf("%d",minPalindromicCutMemoized(input,0,input.length()-1, new int[input.length()][input.length()]));
        pw.flush();
    }

    private static int minPalindromicCutMemoized(String str,int st,int end, int[][] dp){
        if(st<0 || end>str.length())
            return 0;

        if(st==end){
            return 0;
        }
        if(dp[st][end]!=0)
            return dp[st][end];
        
        if(isPalindrome(str,st,end))
            return 0;


        int overallMin = Integer.MAX_VALUE;
        for (int cutPoint = st; cutPoint <end ; cutPoint++) {
            int mpcSubstring_FirstHalf = minPalindromicCutMemoized(str,st,cutPoint,dp);
            int mpcSubstring_SecondHalf = minPalindromicCutMemoized(str, cutPoint+1,end,dp);
            overallMin = Math.min(overallMin,mpcSubstring_FirstHalf+mpcSubstring_SecondHalf+1);
        }
        dp[st][end] = overallMin;
        return overallMin;
    }

    private static boolean isPalindrome(String str, int st, int end) {
        int left = st;
        int right = end;
        while (left<=right){
            if(str.charAt(left)==str.charAt(right)) {
                left++;
                right--;

            }
            else
                return false;
        }
        return true;
    }
}
