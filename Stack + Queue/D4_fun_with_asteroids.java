import java.util.*;
 import java.io.*;
 public class D4_fun_with_asteroids {
 	  public static int[] asteroidCollision(int[] asteroids) {
 	      
 	      Stack<Integer>st = new Stack<>();
 	      
 	      for(int i=0;i<asteroids.length;i++){
 	          if(st.empty()||st.peek()<=0||asteroids[i]>=0){
 	              st.push(asteroids[i]);
 	              continue;
 	          }
 	          
 	          if(st.peek()>0&&asteroids[i]<0){
 	              
 	              while(!st.empty()&&st.peek()<asteroids[i]){
 	                  int a = st.pop();
 	                  if(a==asteroids[i]){
 	                    break;
 	                  }
 	                  st.push(asteroids[i]);
 	                  
 	              }
 	              
 	          }
 	          
 	      }
 	      int[] arr = new int[st.size()];
 	      for(int i=arr.length-1;i>=0;i--){
 	          arr[i]=st.pop();
 	      }
 	      return arr;
 	  }
 	  
 
 
 
 
 	 // Dont make changes 
 	 public static void main(String[] args) {
 	     Scanner sc=new Scanner(System.in);
 	     int n=sc.nextInt();
 	     int ast[]=new int[n];
 	     for(int i=0;i<n;i++)ast[i]=sc.nextInt();
 	     int res[]=asteroidCollision(ast);
 	     for(int v:res){
 	     	 System.out.println(v);
 	     }
 	 }
 
 }
