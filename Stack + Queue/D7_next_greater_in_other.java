import java.util.*;
 public class D7_next_greater_in_other {
 	  public static int[] nextGreaterOther(int[] nums1, int[] nums2) {
 	      
 	      HashMap<Integer,Integer>map = new HashMap<>();
 	      
 	      for(int i=0;i<nums1.length;i++){
 	          for(int j=0;j<nums2.length;j++){
 	              if(nums1[i]==nums2[j]){
 	                  map.put(nums1[i],j);
 	              }
 	          }
 	      }
 	      
 	      int[] arr = getNGE(nums2,nums2.length);
 	      int[] ans = new int[nums1.length];
 	      for(int i=0;i<ans.length;i++){
 	          ans[i]=arr[map.get(nums1[i])];
 	      }
 	      return ans;
 	      
 	  }
 	  
 	  
 	  static int[] getNGE(int arr[], int n) 
  	  { 
  	  	   
  	  	   Stack<Integer> st = new Stack<>();
  	  	   int [] ans = new int[n];
  	  	   for(int i=0;i<arr.length;i++){
  	  	       
  	  	       if(st.empty()){
  	  	           st.push(i);
  	  	           continue;
  	  	       }
  	  	       while(!st.empty()&&arr[st.peek()]<=arr[i]){
  	  	           ans[st.pop()] = arr[i];
  	  	       }
  	  	       st.push(i);
  	  	       
  	  	   }
  	  	   
  	  	   while(!st.empty()){
  	  	       ans[st.pop()]=-1;
  	  	   }
  	  	   
  	  	   return ans;
  	  	   
  	  	   
  	  	   
  	  } 
 	 
 	 // Dont make changes here
 	 public static void main(String[] args) {
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n1=sc.nextInt(), n2=sc.nextInt();
 	 	 int[] nums1=new int[n1]; int[] nums2=new int[n2];
 	 	 for(int i=0;i<n1;i++)nums1[i]=sc.nextInt();
 	 	 for(int i=0;i<n2;i++)nums2[i]=sc.nextInt();
 	 	 int[] res=nextGreaterOther(nums1, nums2);
 	 	 for(int i=0;i<n1;i++)System.out.print(res[i] + " ");
 	 }
 
 }
