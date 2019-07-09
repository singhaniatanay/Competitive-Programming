import java.util.*;
 public class D7_next_greater_circular {
 
     public static int[] nextGreaterCircularInManner(int[] nums) {
       
       int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
  	  	   
  	  	   
       
     }
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int n=sc.nextInt();
         int[] nums=new int[n];
         for(int i=0;i<n;i++){
             nums[i]=sc.nextInt();
         }
         int[] res=nextGreaterCircularInManner(nums);
         for(int i=0;i<res.length;i++)
             System.out.print(res[i]+" ");
     }
 }
