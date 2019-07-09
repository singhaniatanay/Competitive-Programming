import java.util.*;
 
 class D6_reversal_of_queue {
 
     public static Queue<Integer> rev(Queue<Integer> q) {
         
         Stack<Integer>st = new Stack<>();
         while(q.size()!=0){
             st.push(q.remove());
         }
         while(!st.empty()){
             q.add(st.pop());
         }
         return q;
         
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         Queue<Integer> q = new LinkedList<>();
         for (int i = 0; i < n; i++) {
             q.add(sc.nextInt());
         }
         Queue<Integer> res = rev(q);
         while (res.size() != 0) {
             System.out.println(res.remove()+" ");
         }
     }
 }
