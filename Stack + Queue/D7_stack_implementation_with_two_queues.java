import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 class D7_stack_implementation_with_two_queues
 {
     static Queue<Integer> dq = new LinkedList<Integer>();
     static Queue<Integer> hq = new LinkedList<Integer>();
     
     /*The method pop which return the element poped out of the stack*/
     static int pop()
     {
         if(dq.size()==0){
             return -1;
         }
         while(dq.size()!=1){
             hq.add(dq.remove());
         }
         int x = dq.remove();
         while(hq.size()!=0){
            dq.add(hq.remove());
         }
         return x;
     }
 	 
     /* The method push to push element into the stack */
     static void push(int a)
     {
         dq.add(a);
     }
     
 	 //Dont make changes here
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         for(int i=0;i<n;i++){
             int q=sc.nextInt();
             if(q==1){
                 int val=sc.nextInt();
                 push(val);
             }
             else if(q==2){
                 System.out.println(pop());
             }
         }
     }
 }
