import java.util.Scanner;

public class GFG_03_Max_Size_ISub_Matrix_with_all_1s_in_binary_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] answers = new int[t];
        for (int i = 0; i <t ; i++) {
            int[][] matrix = new int[sc.nextInt()][sc.nextInt()];
            for (int j = 0; j <matrix.length ; j++) {
                for (int k = 0; k <matrix[0].length ; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            answers[i] = maxSizSubMatrix(matrix);
        }
        for(int i:answers){
            System.out.println(i);
        }
    }
    public static int maxSizSubMatrix(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 0; i <dp[0].length ; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(matrix[i][j]==1){
                    int left= dp[i][j-1];
                    int up = dp[i-1][j];
                    int diag = dp[i-1][j-1];
                    dp[i][j] = Math.min(left,Math.min(up,diag))+1;
                }else{
                    dp[i][j]=0;
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        int maxI = Integer.MIN_VALUE;
        int maxJ = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                if(dp[i][j]>maxVal){
                    maxVal = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }


        for (int i = maxI; i>maxVal-maxI ; i--) {
            for (int j = maxJ; j>maxVal-maxJ ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        return maxVal;
    }

}
