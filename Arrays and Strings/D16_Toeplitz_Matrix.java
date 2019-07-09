import java.util.*;

class D16_Toeplitz_Matrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        //Write your code here
        for (int i = 0; i <matrix.length-1 ; i++) {
            for (int j = 0; j < matrix[0].length-1; j++) {
                if(matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(isToeplitzMatrix(arr));
    }
}