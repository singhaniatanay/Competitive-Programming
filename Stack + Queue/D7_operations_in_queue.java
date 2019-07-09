import java.util.*;
 class D7_operations_in_queue{
     static HashMap<Integer,Integer> map = new HashMap<>();
     static void insert(Queue<Integer> q, int k){
         
         map.put(k,map.containsKey(k)?map.get(k)+1:1);
         q.add(k);
     }
     static int findFrequency(Queue<Integer> q, int k){
         return map.containsKey(k)?map.get(k):-1;
     }
     
     //Dont make changes here
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int m=sc.nextInt();
         Queue<Integer>q=new LinkedList<>();
         for(int i=0;i<n;i++)insert(q, sc.nextInt());
         for(int i=0;i<m;i++)
             System.out.print(findFrequency(q, sc.nextInt())+" ");
     }
 }
