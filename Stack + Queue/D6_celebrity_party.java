import java.util.*;
 
 class D6_celebrity_party {
 
     static int getId(int M[][], int n) {
         
         Stack<Integer> st = new Stack<>();
         for(int i=0;i<n;i++){
             st.push(i);
         }
         
         while(st.size()!=1){
             int x = st.pop();
             int y = st.pop();
             if(M[x][y]==1){
                 st.push(y);
             }else{
                 st.push(x);
             }
         }
         int celeb = st.pop();
         for(int i=0;i<n;i++){ 
             if(M[celeb][i]==1&&celeb!=i){
                 return -1;
             }
             if(M[i][celeb]==0&&celeb!=i){
                 return -1;
             }
         }
         return celeb;
         
         
         
     }
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[][] M = new int[n][n];
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 M[i][j] = sc.nextInt();
             }
         }
         System.out.println(getId(M, n));
     }
 }
