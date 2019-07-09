import java.util.*;
  import java.lang.*;
  import java.io.*;
  
  class D3_long_parenthesis {
      public static int longestParenthesis(String s){
          
          Stack<Character> bracketStack = new Stack<>();
          Stack<Integer> indexStack = new Stack<>();
          int ans=0;
          bracketStack.push(')');
          indexStack.push(-1);
          for(int i=0;i<s.length();i++){
              if(s.charAt(i)=='('){
                  bracketStack.push('(');
                  indexStack.push(i);
              }else{
                  if(bracketStack.peek()==')'){
                      bracketStack.push(')');
                      indexStack.push(i);
                  }else if(bracketStack.peek()=='('){
                      bracketStack.pop();
                      indexStack.pop();
                      if(i-indexStack.peek()>ans)
                        ans = i-indexStack.peek();
                      
                      
                      
                  }
              }
          }
          
          return ans;
          
      }
  
  
  
  
  
  
  
  
  	  // Dont make changes here
  	  public static void main (String[] args) {
  	      	  Scanner scn=new Scanner(System.in);
  
  	          String s=scn.next();
  	          System.out.println(longestParenthesis(s));
  
  	      
  	  }
  }
