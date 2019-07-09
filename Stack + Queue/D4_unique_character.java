import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D4_unique_character {
 
     public static void uniqueChar(char[] str){
         
         HashMap<Character,Integer>map = new HashMap<>();
         Queue <Character> q = new LinkedList<>();
         
         for(int i=0;i<str.length;i++){
             char ch =str[i];
             map.put(ch,map.containsKey(ch)?map.get(ch)+1:1);
             while(q.size()!=0&&map.get(q.peek())!=1){
                 q.remove();
             }
             if(map.get(ch)==1){
                 q.add(ch);
             }
             if(q.size()==0){
                 System.out.print(-1+" ");
             }else{
                 System.out.print(q.peek()+" ");
             }
         }
         
         
         
     }
 
 
 
 
 
 
 
 
     //Dont make changes here
     public static void main(String[] args) {
 
         Scanner sc= new Scanner(System.in);
 
         	 
             int n=sc.nextInt();
             char ch[]=new char[n];
 
             for (int i=0; i<n;i++){
                 ch[i]=sc.next().charAt(0);
                 
             }
             uniqueChar(ch);
 
 
         
 
     }
 
 }
