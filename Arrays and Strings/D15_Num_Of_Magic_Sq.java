import java.util.*;

public class D15_Num_Of_Magic_Sq {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] Input = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Input[i][j] = scn.nextInt();
            }
        }
        System.out.print(numMagicSquaresInside(Input));
    }

    // -----------------------------------------------------
    // This is a functional problem. Do not make changes to main
    // This function takes as input an array and integer k.
    // It should print required output.
    public static int numMagicSquaresInside(int[][] grid) {
        // Write your code here
        int count=0;
        for (int i = 0; i < grid.length-2; i++) {
            for (int j = 0; j < grid[0].length-2; j++) {
                if(grid[i+1][j+1]!=5){
                    //impossible solution
                    continue;
                }
                int row1 = grid[i][j]+grid[i][j+1]+grid[i][j+2];
                int row2 = grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
                int row3 = grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
                if(row1!=row2 || row2!=row3 ){
                    continue;
                }
                int diag1 = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
                int diag2 = grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
                if(diag1!=diag2 || diag2!=row1){
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}