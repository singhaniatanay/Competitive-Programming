import java.util.*;
 class D7_nearmost_left_smaller_number {
 
 	 static void printNearmostLeftSmaller(int arr[], int n) { 
 	     
 	     Stack<Integer> st = new Stack<>();
 	     int[] ans = new int[n];
 	     for(int i=0;i<arr.length;i++){
 	         while(!st.empty()&&arr[st.peek()]>=arr[i]){
 	             st.pop();
 	         }
 	         if(st.empty()){
 	             ans[i]=-1;
 	         }else{
 	             ans[i]=arr[st.peek()];
 	         }
 	         st.push(i);
 	         
 	     }
 	     
 	     for(int i=0;i<ans.length;i++){
 	         System.out.print(ans[i]+" ");
 	     }
 	     
 	 } 
 
 
 	 //Dont make changes here
 	 public static void main(String[] args) { 
             Scanner sc=new Scanner(System.in);
             int n=sc.nextInt();
             int arr[] = new int[n]; 
             for(int i=0;i<n;i++)arr[i]=sc.nextInt();
 	 	 printNearmostLeftSmaller(arr, n); 
 	 } 
 }
