/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    	static int[] xv = new int[]{2, 2, -2, -2, 1, -1, 1, -1};
	static int[] yv = new int[]{1, -1, 1, -1, 2, 2, -2, -2};
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int N = sc.nextInt();
		    int sx = sc.nextInt();
		    int sy = sc.nextInt();
		    int tx = sc.nextInt();
		    int ty = sc.nextInt();
            int[][] chess = new int[N][N];
		    for(int i = 0; i < N; i++){
		        for(int j = 0; j < N; j++){
		            chess[i][j] = 0;
		        }
		    }
		    System.out.println(moves(chess, N, sx-1, sy-1, tx-1, ty-1));		}
	}
	
	static int moves(int[][] chess, int N, int kx, int ky, int tx, int ty){
	   Queue<Integer> iq = new LinkedList<Integer>();
	   Queue<Integer> jq = new LinkedList<Integer>();
	   Queue<Integer> moves = new LinkedList<Integer>();
	   
	   iq.add(kx);
	   jq.add(ky);
	   moves.add(0);
	   
	   while(!iq.isEmpty()){
	       int x = iq.remove();
	       int y = jq.remove();
	       int move = moves.remove();
	       if(x == tx && y == ty) return move;
	       chess[x][y] = -1;
	       for(int p = 0; p < 8; p++){
	           int xn = x + xv[p];
	           int yn = y + yv[p];
	           if(xn < 0 || yn < 0) continue;
	           if(xn >= N || yn >= N) continue;
	           if(chess[xn][yn] == -1) continue;
	           iq.add(xn);
	           jq.add(yn);
	           moves.add(move + 1);
	       }
	   }
	   return 1;
	}}