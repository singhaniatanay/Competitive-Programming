import java.util.*;

class D13_ISLAND_PERIMETER{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int row=scn.nextInt();
        int col=scn.nextInt();
        int[][] grid= new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j]=scn.nextInt();
            }
        }
        System.out.print(islandPerimeter(grid));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input a matrix.
    // It should return perimeter value.
    public static int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int curr = grid[i][j];
                if(curr==1){
                    islands++;
                    if(j+1<grid[0].length&&grid[i][j+1]==1){
                        neighbours++;
                    }
                    if(i+1<grid.length&&grid[i+1][j]==1){
                        neighbours++;
                    }
                }
            }
        }
        return ((4*islands) - (2*neighbours));
    }
}