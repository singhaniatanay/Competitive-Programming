/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class Pair{
        int x;
        int y;
        Pair(int a,int b){
            this.x = a;
            this.y = b;
        }
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int r = sc.nextInt();
		    int c = sc.nextInt();
		    int[][] mat = new int[r][c];
		    int count =0;
		    Queue<Pair> q = new LinkedList<>();
		    for(int i=0;i<r;i++){
		        for(int j=0;j<c;j++){
		            mat[i][j] = sc.nextInt();
		            if(mat[i][j]!=0) count++;
		            if(mat[i][j]==2) q.add(new Pair(i,j));
		        }
		    }
		    int total =0;
		    int result = 0;
		    while(!q.isEmpty()){
		        total+= q.size();
		        int size = q.size();
		        
		        result++;
		        while(size-->0){
		            Pair p = q.remove();
		            int x = p.x;
		            int y = p.y;
		            //up
		            if(y-1>=0 && mat[x][y-1]==1){
		                //rot it
		                mat[x][y-1] = 2;
		                q.add(new Pair(x,y-1));
		            }
		            //down
		            if(y+1<c && mat[x][y+1]==1){
		                //rot it
		                mat[x][y+1] = 2;
		                q.add(new Pair(x,y+1));
		            }
		            //left
		            if(x-1>=0 && mat[x-1][y]==1){
		                //rot it
		                mat[x-1][y] = 2;
		                q.add(new Pair(x-1,y));
		            }
		            //right
		            if(x+1<r && mat[x+1][y]==1){
		                //rot it
		                mat[x+1][y] = 2;
		                q.add(new Pair(x+1,y));
		            }
		        }
		        if(total==count) break;
		    }
		    if(total==count) System.out.println(result);
		    else System.out.println(-1);
		    
		}
	}
}