import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D26_4_Keys_Keyboard {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        pw.println(maxNoOfPrint(Integer.parseInt(br.readLine())));
        pw.flush();
    }
    public static int maxNoOfPrint(int steps){
        if(steps<=2){
            return steps;
        }
        int[] dp = new int[steps+1];
        dp[0]=0;
        dp[1] = 1;
        dp[2] = 2;
        for (int currSteps = 3; currSteps <dp.length ; currSteps++) {
            int pastedAtCurr = Integer.MIN_VALUE;
            for (int i = 3; i <=currSteps-1 ; i++) {
                pastedAtCurr = Math.max(pastedAtCurr,((i-1)*dp[currSteps-i]));
            }
            int typedAtCurr = dp[currSteps-1]+1;
            dp[currSteps] = Math.max(pastedAtCurr,typedAtCurr);
        }
        return dp[steps];

    }

}
