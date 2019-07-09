import java.util.*;
 public class D6_k_reverse_in_a_queue {
 
 
 	 // Function to reverse the first K elements 
 	 // of the Queue 
 	 static void reverseQueueFirstKElements(Queue<Integer>q, int k) { 
 	     
 	     Stack<Integer> st = new Stack<>();
 	     for(int i=0;i<k;i++){
 	         st.push(q.remove());
 	     }
 	     while(!st.empty()){
 	         q.add(st.pop());
 	     }
 	     for(int i=k;i<q.size();i++){
 	         q.add(q.remove());
 	     }
 	     while(q.size()!=0){
 	         System.out.print(q.remove()+" ");
 	     }
 	 }
 
 
 
 
 
 
 
 
 	 // Driver code 
 	 public static void main(String args[]) {
 	 	 Queue<Integer> q=new LinkedList<Integer>(); 
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 int k=sc.nextInt();
 	 	 for(int i=0;i<n;i++)q.add(sc.nextInt());
 	 	 reverseQueueFirstKElements(q, k);
 	 } 
 }
