import java.util.Arrays;
import java.util.Scanner;

public class D23_GoldMineTabulated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(goldMineTab(mat));
    }
    public static int goldMineTab(int[][] mat){
        int[][] dp = Arrays.copyOf(mat,mat.length);
        int Badamax=Integer.MIN_VALUE;
        for (int col = dp[0].length-2;col>=0 ; col--) {
            for (int row = dp.length-1; row>=0 ; row--) {
                int upper = row-1>0?dp[row-1][col+1]:0;
                int right = dp[row][col+1];
                int rightDown = row+1<dp.length?dp[row+1][col+1]:0;
                int max = Math.max(upper,Math.max(right,rightDown));
                dp[row][col] += max;
                Badamax = Math.max(Badamax,dp[row][col]);
            }
        }
        return Badamax;
    }
}
