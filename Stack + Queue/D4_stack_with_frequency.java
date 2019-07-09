import java.util.HashMap;
  import java.util.Map;
  import java.util.Scanner;
  import java.util.Stack;
  
  class D4_stack_with_frequency{
  private static class FreqStack {
      // Write your code 
      static int maxFreq=0;
        public static HashMap<Integer,Integer> fmap = new HashMap<>();
        public static HashMap<Integer,Stack<Integer>> stackmap = new HashMap<>();
      public FreqStack() {
          
          
      }
  
      public static void push(int x) {
          
          fmap.put(x,fmap.containsKey(x)?fmap.get(x)+1:1);
          if(fmap.get(x)>maxFreq){
              maxFreq = fmap.get(x);
          }
          
          
          if(stackmap.containsKey(fmap.get(x))){
              Stack st =stackmap.get(fmap.get(x));
              st.push(x);
              stackmap.put(fmap.get(x),st);
          }else{
              Stack<Integer> st = new Stack<>();
          st.push(x);
              stackmap.put(fmap.get(x),st);
          }
          
                                            
          
          
  	  }
  
      public static int pop() {
          
          int ans = stackmap.get(maxFreq).pop();
          fmap.put(ans,fmap.get(ans)-1);
          if(stackmap.get(maxFreq).empty()){
              maxFreq--;
          }
         return ans;
          
      }
  }
       
  
  
  
  
  
  
  	  //Dont make changes here
  	  public static void main(String[] args){
      	   FreqStack fq=new FreqStack();
      	   Scanner sc=new Scanner(System.in);
      	   int n=sc.nextInt();
      	   int i=0;
      	   while(i!=n){
      	  	   int q=sc.nextInt();
      	  	   if(q==1){
  	  	  	  i++;
      	  	  	   fq.push(sc.nextInt());
      	  	   }
      	  	   else if(q==2)System.out.println( fq.pop());
      	  	   i++;
      	   }
       	  }
      
  
  }

