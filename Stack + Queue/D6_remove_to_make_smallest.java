import java.util.*;
  import java.util.Scanner;
  
  public class D6_remove_to_make_smallest {
  
      public static String removeMakeSmallest(String num, int k) {
          
          Stack<Character> st = new Stack<>();
          for(int i=0;i<num.length();i++){
              if(st.empty()){
                  st.push(num.charAt(i));
                  continue;
              }
              while(!st.empty()&&st.peek()>num.charAt(i)&&k--!=0){
                  st.pop();
              }
              st.push(num.charAt(i));
          }

          while(k-->0&&!st.empty()){
              st.pop();
          }
          
          String ans = "";
          while(!st.empty()){
              ans = st.pop()+ans;
          }
          while(ans.charAt(0)=='0'){
              ans = ans.substring(1);
          }
          return ans;
      }
  
      
      
      
      
      
      
      
      
      
      
      
      public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int k=sc.nextInt();
          String s=sc.next();
          System.out.println(removeMakeSmallest(s, k));
      }
      
  }
