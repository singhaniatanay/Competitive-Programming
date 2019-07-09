import java.util.*;
 public class D7_score_of_the_string {
 
    public static int scoreOfParentheses(String s) {
        
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='('){
                st.push("(");
                continue;
            }
            else{
                if(st.peek().equals("(")){
                    st.pop();
                    st.push("1");
                    continue;
                }
                int score=0;
                while(!st.peek().equals("(")){
                    score+=Integer.parseInt(st.pop());
                }
                st.pop();
                st.push(2*score+"");
            }
        }
        int score = 0;
        while(!st.empty()){
            score+=Integer.parseInt(st.pop());
        }
        return score;
        
        
    }
     
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         String s=sc.next();
         System.out.println(scoreOfParentheses(s));
     }
     
 
 }
