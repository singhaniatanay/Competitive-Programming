import java.util.*;
 
 class D7_sorted_stack
 { 
 	 // This function return the sorted stack 
 	 public static Stack<Integer> sortstack(Stack<Integer> 
 	 	 	 	 	 	 	 	 	 	 	 input) 
 	 { 
 	     Stack<Integer> tmpStack = new Stack<Integer>(); 
        while(!input.isEmpty()) 
        { 
            int tmp = input.pop(); 
          
            
            while(!tmpStack.isEmpty() && tmpStack.peek()  
                                                 > tmp) 
            { 
            input.push(tmpStack.pop()); 
            } 
              
            tmpStack.push(tmp); 
        } 
        return tmpStack; 
 	 } 
 	 
 
 
 
 	 // Dont make changes here 
 	 public static void main(String args[]) 
 	 { 
 	 	 Stack<Integer> input = new Stack<Integer>(); 
 	 	 Scanner sc=new Scanner(System.in); 
                 int n=sc.nextInt();
 	 	 for(int i=0;i<n;i++)input.push(sc.nextInt());
                 
                 Stack<Integer> res=sortstack(input); 
 	 	 
 	 	 while (!res.empty()) 
 	 	 { 
 	 	 	 System.out.print(res.pop()+" "); 
 	 	 } 
 	 } 
 }
