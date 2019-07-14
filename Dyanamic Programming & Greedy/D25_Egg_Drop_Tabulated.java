import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D25_Egg_Drop_Tabulated {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String[] vals = br.readLine().split(" ");
        pw.println(eggDropTabulated(Integer.parseInt(vals[0]),Integer.parseInt(vals[1])));
        pw.flush();
    }

    private static int eggDropTabulated(int eggs, int floors) {
        int[][] dp = new int[eggs+1][floors+1];
        for (int e = 1; e <=eggs ; e++) {
            for (int f = 1; f <=floors ; f++) {
                if(f==1){
                    dp[e][f] = 1;
                } else if (e == 1) {
                    dp[e][f]=f;
                }else{
                    int min = Integer.MAX_VALUE;
                    for (int k = 1; k <=f; k++) {
                        int phootGaya = dp[e-1][f-k];
                        int bachGaya = dp[e][k-1];
                        min = Math.min(min,Math.max(phootGaya,bachGaya));
                    }
                    dp[e][f] = min+1;
                }
            }
        }
        return dp[eggs][floors];
    }
}
