import java.util.*;

public class D13_VALID_SUDOku {

    // This is a functional problem. You have to complete this function.
    // It takes as input a 2D array of characters. It should return true if the
    // board is valid, else should return false.
    public static boolean isValidSudoku(char[][] board) {
        // write your code here.
        int row[]=new int[9];
        int col[] = new int[9];
        int sm[][] = new int[3][3];
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if(board[i][j]!='.') {
                    if (((row[i] & (1 << (board[i][j] - '0'))) != 0)) {
                        return false;
                    }
                    if (((col[j] & (1 << (board[i][j] - '0'))) != 0)) {
                        return false;
                    }
                    if (((sm[i/3][j/3] & (1 << (board[i][j] - '0'))) != 0)) {
                        return false;
                    }
                    row[i] = row[i] | (1<<(board[i][j] - '0'));
                    col[j] = col[j] | (1<<(board[i][j] - '0'));
                    sm[i/3][j/3] = sm[i/3][j/3] | (1<<(board[i][j]-'0'));
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        if (isValidSudoku(board)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

    }

}