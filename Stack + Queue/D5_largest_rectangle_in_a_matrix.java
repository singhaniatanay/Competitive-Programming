import java.util.Scanner;
 import java.util.Stack;
 
 public class D5_largest_rectangle_in_a_matrix {
  
 public static int maxrect(int arr[][]){
     int max = 0;
     int[] ht = new int[arr[0].length];
     for(int i=0;i<arr.length;i++){
         for(int j=0;j<arr[i].length;j++){
             if(i==0){
                 ht[j]=arr[i][j];
             }else{
                 if(arr[i][j]==1){
                     ht[j]=ht[j]+1;
                 }else{
                     ht[j]=0;
                 }
             }
         }
         max = Math.max(max,maxRectArea(ht));
     }
     return max;
     
 }
 
      public static int maxRectArea(int[] ht) {
          
          int [] arr1 = leftSmaller(ht);
          int[] arr2 = rightSmaller(ht);
          int max=0;
          for(int i=0;i<arr1.length;i++){
              int area = (arr2[i]-arr1[i]+1)*ht[i];
              if(area>max){
                  max=area;
              }
          }
          return max;
  	  }
  
      public static int[] leftSmaller(int[] arr){
          Stack<Integer> st = new Stack<>();
          int ans[] = new int[arr.length];
          
          for(int i=0;i<arr.length;i++){
              
              while(!st.empty()&&arr[st.peek()]>arr[i]){
                  st.pop();
              }
              ans[i]=st.size()==0?0:st.peek()+1;
              st.push(i);
              
          }
            
          return ans;
          
      }
      
      public static int[] rightSmaller(int[] arr){
          Stack<Integer> st = new Stack<>();
          int ans[] = new int[arr.length];
          
          for(int i=arr.length-1;i>=0;i--){
              
              while(!st.empty()&&arr[st.peek()]>=arr[i]){
                  st.pop();
              }
              ans[i]=st.size()==0?arr.length-1:st.peek()-1;
              st.push(i);
              
          }
            
          return ans;
          
      }
 
 	 //Dont make changes
 	 public static void main(String[] args) {
 	 	 Scanner sc=new Scanner(System.in);	 
 	 	 int row=sc.nextInt();
 	 	 int col=sc.nextInt();
 	 	 int[][] A=new int[row][col];
 	 	 for(int i=0;i<row;i++)
 	 	 	 for(int j=0;j<col;j++)
 	 	 	 	 A[i][j]=sc.nextInt();
           System.out.println( maxrect(A));
     
 	 }
 
 }
