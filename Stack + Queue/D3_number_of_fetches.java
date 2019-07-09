import java.util.LinkedList;
 import java.util.Queue;
 import java.util.Scanner;
 
 class D3_number_of_fetches{
 	 // Complete the functions
 	 static class RecentFetch {
     	 static Queue<Integer>  q = new LinkedList<>();

     	 public int ping(int t) {
     	     q.add(t);
     	     while(q.peek()<t-3000){
     	         q.remove();
     	     }
     	     return q.size();
     	 }
     
 
 	 }
 
 	 // Dont make changes here 
 	 public static void main(String[] args){
 	 	 RecentFetch rf=new RecentFetch();
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 for(int i=0;i<n;i++){
 	 	 	 System.out.print(rf.ping(sc.nextInt())+" ");
 	 	 }
 	 }
 
 
 }
