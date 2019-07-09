import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D4_rotation_of_cards {
 
     public static void cardRotation(int N) {
         
         //Card vs selection order
         HashMap<Integer,Integer> map = new HashMap<>();
         Queue<Integer> q = new LinkedList<>();
         int rot = 1;
         int select = 1;
         for(int i=1;i<=N;i++){
             q.add(i);
         }
         while(q.size()!=0){
            //  if(rot>q.size()){
            //      rot=rot%q.size();
            //  }
             for(int i=0;i<rot;i++){
                 q.add(q.remove());
             }
             rot++;
             map.put(q.remove(),select++);
         }
         
         for(int i=1;i<=N;i++){
             System.out.print(map.get(i)+" ");
         }
         
         
     }
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         cardRotation(N);
     }
 
 }
