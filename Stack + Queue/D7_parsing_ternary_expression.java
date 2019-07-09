import java.util.*;
 
 class D7_parsing_ternary_expression {
 
     public static String parseTernary(String s) {
         
         Stack<String> st = new Stack<>();
         for(int i=s.length()-1;i>=0;i--){
             if(s.charAt(i)==':')
                continue;
            
             if(s.charAt(i)=='?'&&(s.charAt(i-1)=='T'||s.charAt(i-1)=='F')){
                 if(s.charAt(--i)=='F'){
                     st.pop();
                 }else{
                     String a =st.pop();
                     st.pop();
                     st.push(a);
                 }
                 continue;
             }
             else{
                 st.push(s.charAt(i)+"");
                 while(i>0&&(s.charAt(i-1)!=':'&&s.charAt(i-1)!='?')){
                     st.push(s.charAt(--i)+st.pop()); //If 2 or more digits come
                 }
                 continue;
             }
         }
         return st.peek();
         
     }
 
     // Dont make chsnges here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print(parseTernary(sc.next()));
     }
 }
