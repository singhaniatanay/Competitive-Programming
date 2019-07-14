import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D25_Minimum_Palindromic_Cut_Tabulated {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String input = br.readLine();
        pw.printf("%d",minPalindromicCutTabulated(input));
        pw.flush();
    }

    private static int minPalindromicCutTabulated(String input) {
        if(input.length()<=0)
            return 0;

        boolean[][] haiKiNahi = new boolean[input.length()][input.length()];
        for (int gap = 0; gap <haiKiNahi.length ; gap++) {
            for (int i = 0,j=i+gap; j < haiKiNahi.length; i++,j++) {
                if(gap==0) {
                    haiKiNahi[i][j] = true;
                }
                else if(gap==1){
                    haiKiNahi[i][j] = input.charAt(i)==input.charAt(j);
                }else{
                    haiKiNahi[i][j] = (input.charAt(i)==input.charAt(j)&&
                            haiKiNahi[i+1][j-1]);
                }

            }
        }
        int[][] dp = new int[haiKiNahi.length][haiKiNahi.length];
        for (int gap = 0; gap <dp.length ; gap++) {
            for (int i = 0,j=i+gap; j < dp.length; i++,j++) {
                if(gap==0) {
                    dp[i][j] = 0;
                    continue;
                }
                else if(gap==1) {
                    dp[i][j] = haiKiNahi[i][j] ? 0 : 1;
                }else{
                    if(haiKiNahi[i][j]){
                        dp[i][j] = 0;
                        continue;
                    }
                    int minVal = Integer.MAX_VALUE;
                    for (int cutPt = i; cutPt <j; cutPt++) {
                        int firstPart = dp[i][cutPt];
                        int secondPart = dp[cutPt+1][j];
                        int val = firstPart+secondPart+1;
                        if(val<minVal)
                            minVal = val;
                    }
                    dp[i][j] = minVal;
                }
            }
        }
        return dp[0][dp.length-1];

    }


}
