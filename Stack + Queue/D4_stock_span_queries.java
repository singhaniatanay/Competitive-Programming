import java.util.*;
  class D4_stock_span_queries{
  static class StockSpanner {
  // Complete the functions
  
  Stack<Integer> st1,st2;
      public StockSpanner() {
          st1 = new Stack<>();  //Stores spans
          st2 = new Stack<>();  //Stores prices
      }
  
      public int next(int price) {
          
          if(st1.empty()){
              st1.push(1);
              st2.push(price);
              return 1;
          }
          int span=1;
          while(!st2.empty()&&st2.peek()<=price){
              span+=st1.pop();
              st2.pop();
          }
          st1.push(span);
          st2.push(price);
          return span;
          
      }
  
  }
  
  
  
  //Dont make changes here
  	  public static void main(String[] args){
  	  	  StockSpanner ss=new StockSpanner();
  	  	  Scanner sc=new Scanner(System.in);
  	  	  int n=sc.nextInt();
  	  	  for(int i=0;i<n;i++){
  	  	  	  System.out.println(ss.next(sc.nextInt()));
  	  	  }
  	  }
  
  
  
  
  }
