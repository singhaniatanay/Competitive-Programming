import java.util.Arrays;
import java.util.Scanner;

public class D23_Max_Size_Sq_In_A_Matrix {
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
        System.out.println(maxSizeSquare(mat));
    }
    public static int maxSizeSquare(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp = Arrays.copyOf(matrix, matrix.length);
        int max = Integer.MIN_VALUE;
        for (int i = matrix.length-2; i >=0 ; i--) {
            for (int j =matrix[0].length-2;j>=0 ; j--) {
                if(matrix[i][j]==0){
                    dp[i][j]=0;
                    continue;
                }
                int right = dp[i][j+1];
                int down=dp[i+1][j];
                int diag=dp[i+1][j+1];
                dp[i][j] = Math.min(right,Math.min(down,diag))+1;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
