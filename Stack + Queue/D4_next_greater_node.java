import java.util.*;
 public class D4_next_greater_node {
 	 /* Structure of ListNode
 	 	 ListNode {
 	 	       int val;
 	 	       ListNode next;
 	 	       ListNode(int x) { val = x; }
 	 	   }
 	 */
 	  public static int[] nextLargerNodes(ListNode head) {
 	      
 	      ListNode i=head,j=head;
 	      int size=0;
 	      for(ListNode temp=head;temp!=null;temp=temp.next){
 	          size++;
 	      }
 	      int[] ans = new int[size];
 	      int index=0;
 	      while(i!=null){
 	          if(j==null){
 	              ans[index]=0;
 	              i=i.next;
 	              j=i;
 	              index++;
 	              continue;
 	          }else if(j.val>i.val){
 	              ans[index]=j.val;
 	              i=i.next;
 	              j=i;
 	              index++;
 	              continue;
 	          }
 	          j=j.next;
 	          
 	      }
 	      
 	      return ans;
 	      
 	  }
 
 	 // Dont make changes here
 	 public static void main(String[] args) {
 	 	 Scanner sc = new Scanner(System.in);
 	 	 int size=sc.nextInt();
 	 	 int headval=sc.nextInt();
 	 	 ListNode head=new ListNode(headval);
 	 	 ListNode tail=head;
 	 	 for(int i=1;i<size;i++){
 	 	 	 ListNode curr=new ListNode(sc.nextInt());
 	 	 	 tail.next=curr;
 	 	 	 tail=curr;
 	 	 }
 	 	 int[] res=nextLargerNodes(head);
 	 	 for(int i=0;i<size;i++)System.out.print(res[i]+" ");
 	 }
 	 static class ListNode {
 	       int val;
 	       ListNode next;
 	       ListNode(int x) { val = x; }
 	   }
 
 }
