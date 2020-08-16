// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            if(new Sudoku().SolveSudoku(grid) == true)
                new Sudoku().printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Sudoku
{
    static boolean SolveSudoku(int board[][])
    {
        // add your code here
        int row = -1; 
        int col = -1; 
        boolean isEmpty = true; 
        for (int i = 0; i < 9; i++) 
        { 
            for (int j = 0; j < 9; j++)  
            { 
                if (board[i][j] == 0)  
                { 
                    row = i; 
                    col = j; 
                      
                    // we still have some remaining 
                    // missing values in Sudoku 
                    isEmpty = false;  
                    break; 
                } 
            } 
            if (!isEmpty) 
            { 
                break; 
            } 
        } 
      
        // no empty space left 
        if (isEmpty)  
        { 
            return true; 
        } 
      
        // else for each-row backtrack 
        for (int num = 1; num <= 9; num++) 
        { 
            if (isSafe(board, row, col, num)) 
            { 
                board[row][col] = num; 
                if (SolveSudoku(board))  
                { 
                    // print(board, n); 
                    return true; 
                }  
                else
                { 
                    board[row][col] = 0; // replace it 
                } 
            } 
        } 
        return false; 
    }
    public static boolean isSafe(int[][] board,int row,int col,int num)
    {
    for (int d = 0; d < board.length; d++)  
        { 
            // if the number we are trying to  
            // place is already present in  
            // that row, return false; 
            if (board[row][d] == num)  
            { 
                return false; 
            } 
        } 
          
        // column has the unique numbers (column-clash) 
        for (int r = 0; r < board.length; r++) 
        { 
            // if the number we are trying to 
            // place is already present in 
            // that column, return false; 
      
            if (board[r][col] == num) 
            { 
                return false; 
            } 
        } 
      
        // corresponding square has 
        // unique number (box-clash) 
        int sqrt = (int) Math.sqrt(board.length); 
        int boxRowStart = row - row % sqrt; 
        int boxColStart = col - col % sqrt; 
      
        for (int r = boxRowStart; 
                 r < boxRowStart + sqrt; r++)  
        { 
            for (int d = boxColStart;  
                     d < boxColStart + sqrt; d++)  
            { 
                if (board[r][d] == num)  
                { 
                    return false; 
                } 
            } 
        } 
      
            // if there is no clash, it's safe 
        return true; 
}
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}

