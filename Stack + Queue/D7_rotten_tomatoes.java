import java.util.*;
 import java.util.Scanner;
 import java.lang.*;
 import java.io.*;
 
 public class D7_rotten_tomatoes {
     
     public static class Helper{
        public int i,j,time;
        
        Helper(int i,int j,int time){
            this.i=i;
            this.j=j;
            this.time=time;
        }
        
    }
    
     
 	 public static int rottenOranges(int[][] M){
 	  
 	       
 	  Queue<Helper> q = new LinkedList<>();

 	     
 	     int time = -1;
 	     for(int i=0;i<M.length;i++){
 	         for(int j=0;j<M[0].length;j++){
 	             if(M[i][j]==2){
 	                 q.add(new Helper(i,j,0));
 	                 M[i][j]=2;
 	             }
 	         }
 	     }
 	             
        while(q.size()>0){
            ////grm*wa*
            Helper rot = q.remove();
            
            M[rot.i][rot.j]=2;
            time = rot.time;
            if(isValid(M,rot.i+1,rot.j)){
                q.add(new Helper(rot.i+1,rot.j,rot.time+1));

            }
            if(isValid(M,rot.i-1,rot.j)){
                q.add(new Helper(rot.i-1,rot.j,rot.time+1));
            }
            if(isValid(M,rot.i,rot.j+1)){
                q.add(new Helper(rot.i,rot.j+1,rot.time+1));
            }
            if(isValid(M,rot.i,rot.j-1)){
                q.add(new Helper(rot.i,rot.j-1,rot.time+1));
            }
            
            
        }
        for(int i=0;i<M.length;i++){
 	         for(int j=0;j<M[0].length;j++){
 	             if(M[i][j]==1){
 	                 return -1;
 	             }
 	         }
 	     }
 	     
        return time;
 	     
 	 }    
 	 
 	 
 	 public static boolean isValid(int[][]M,int i,int j){
 	     if(i<0||j<0||i>=M.length||j>=M[0].length){
 	         return false;
 	     }
 	     if(M[i][j]!=1){
 	         return false;
 	     }
 	     return true;
 	 }
 
 
 
 	 // Dont make changes here
 	 public static void main (String[] args) {
 	 	 //code
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int r=sc.nextInt();int c=sc.nextInt();
 	 	 int[][] M=new int[r][c];
 	 	 for(int i=0;i<r;i++)
 	 	 	 for(int j=0;j<M[0].length;j++)
 	 	         	 M[i][j]=sc.nextInt();
 	 	 System.out.println(rottenOranges(M));
 	 	 
 	 }
     
  }
