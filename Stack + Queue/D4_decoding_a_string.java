import java.util.*;

class D4_decoding_a_string {
 
 public static String decode(String s) {
     
     Stack<String> st = new Stack<>();
     st.push("");
     for(int i=s.length()-1;i>=0;i--){
         char ch = s.charAt(i);
         if(ch==']'){
             st.push("]");
             continue;
         }
         if(ch>96&&ch<123){
             if(st.peek().equals("]")){
                st.push(ch+"");
             }else{
                 st.push(ch+st.pop());
             }
             continue;
         }
         if(ch=='['){
             String a="";
             while(!st.peek().equals("]")){
             a = a+st.pop();
             }
             st.pop();
             st.push(a);
             continue;
         }
         else{
             String num = "";
             while(i>=0
                        &&s.charAt(i)!=']'
                        &&s.charAt(i)!='['
                        &&s.charAt(i)<96){
                num = s.charAt(i)+num;
                i--;
             }
             i++;
             int j = Integer.parseInt(num);
             String a = st.pop();
             String ans="";
             for(int k=0;k<j;k++){
                 ans=ans+a;
             }
             st.push(ans);
         }
         
     }

     String ans = "";
     while(!st.empty()){
         ans = ans+st.pop();
     }
     return ans;
     
 }
 
 
 //Dont make any changes here
 public static void main(String[] args){
 Scanner sc=new Scanner(System.in);
 String s=sc.next();
 System.out.println(decode(s));
 }
 
 }
