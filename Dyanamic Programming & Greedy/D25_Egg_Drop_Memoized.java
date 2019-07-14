import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D25_Egg_Drop_Memoized {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String[] vals = br.readLine().split(" ");
        pw.println(eggDropMemoized(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]),new int[Integer.parseInt(vals[0])+1][Integer.parseInt(vals[1])+1]));
        pw.flush();
    }
    /*
        we have 'f' floors and 'e' eggs
        obv f>e

        there is a critical floor such that throwing from any floor below that would NOT BREAK
                                        and throwing from any floor above that including Critical floor would make it BREAK

        We need to find MINIMUM No. of TRIALS such that we find the Critical Floor
        We need a GUARANTEED No. of Trials that is NOT THE LUCKY No. of trials
        i.e that no. of trials for which it WORKS(find the CF) when everything goes WRONG

     */
    private static int eggDropMemoized(int eggs, int floors, int[][] dp){
        if(eggs==1)
            return floors;
        if(floors==1)
            return 1;
        if(floors==0)
            return 0;
        if(dp[eggs][floors]!=0){
            return dp[eggs][floors];
        }

        int overMin = Integer.MAX_VALUE;
        for (int i = 1; i <=floors ; i++) {
            int minTrialsIfBreak = eggDropMemoized(eggs-1,i-1,dp);
            int minTrialsIfSurvives = eggDropMemoized(eggs,floors-i,dp);
            overMin = Math.min(Math.max(minTrialsIfBreak,minTrialsIfSurvives),overMin);
        }
        dp[eggs][floors] = overMin+1;
        return overMin+1;
    }
}
