import java.util.*;
 class D7_stack_validation {
     
     
     
     public static boolean validateStackSequences(int[] pushed, int[] popped) {
         
         if(pushed.length!=popped.length){
             return false;
         }
        Stack<Integer>st = new Stack<>();
        int x=0;
         for(int i=0;i<pushed.length;i++){

             while(!st.empty()&&popped[x]==st.peek()){
                 st.pop();
                 x++;
             }
             st.push(pushed[i]);
         }
            while(!st.empty()&&popped[x]==st.peek()){
                 st.pop();
                 x++;
             }
         if(x==pushed.length){
             return true;
         }
         return false;
         
     }
     //Dont make changes here
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int N = sc.nextInt();
         int[] pushed=new int[N];
         int[] popped=new int[N];
         for(int i=0;i<N;i++)pushed[i]=sc.nextInt();
         for(int i=0;i<N;i++)popped[i]=sc.nextInt();
         System.out.print(validateStackSequences(pushed, popped));
     }
 }
