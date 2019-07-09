import java.util.*;
 
 public class D3_merge_multiple_sorted_linked_lists {
     
     
     // -----------------------------------------------------
     // This is a functional problem. You have to complete this function.
     // It takes as input the array of heads of k sorted linked lists, and k.
     // It should return the head of merged list.
     
     public static Node mergeKList(Node []arr, int k){
         
         Node ans1 = merge2List(arr[0],arr[1]);
         for(int i=2;i<arr.length;i++){
             ans1 = merge2List(ans1,arr[i]);
         }
         
         return ans1;
         
     }
     
     public static Node merge2List(Node l1,Node l2){
         Node ans=null;
         Node tail=null;
         if(l1.data<l2.data){
                 ans = new Node(l1.data);
                 tail=ans;
                 l1=l1.next;
          }else{
              ans = new Node(l2.data);
              tail=ans;
                 l2=l2.next;
          }
         while(l1!=null&&l2!=null){
             if(l1.data<l2.data){
                 tail.next = new Node(l1.data);
                 tail=tail.next;
                 l1=l1.next;
             }else{
                 tail.next = new Node(l2.data);
                 tail=tail.next;
                 l2=l2.next;
             }
         }
         if(l1==null){
             tail.next = l2;
             tail=tail.next;
         }
         else if(l2==null){
             tail.next = l1;
             tail=tail.next;
         }
         return ans;
     }
     
     // -----------------------------------------------------
     
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int k = sc.nextInt();
         
         Node[] arr = new Node[k];
         
         Node start = null;
         Node curr = null;
         
         for(int i=0; i < k; i++){
             int n = sc.nextInt();
             int a = sc.nextInt();
             start = new Node(a);
             arr[i] = start;
             
             curr = start;
             for(int j = 1; j < n; j++){
                 Node ptr = new Node(sc.nextInt());
                 curr.next = ptr;
                 curr = ptr;
             }
             curr.next = null;
             start = null;
         }
         
         Node res = mergeKList(arr, k);
         display(res);
         
     }
 
     // Class declaration for a Node of the Linked List
     static class Node {
         int data;
         Node next;
 
         public Node(int data) {
             this.data = data;
             this.next = null;
         }
 
     }
 
     /*
      * Input Parameters: head: head of the linked list in which is to be
      * displayed.
      * 
      * Return Value: null
      */
     public static void display(Node head) {
         for (Node node = head; node != null; node = node.next) {
             System.out.print(node.data + " ");
         }
     }
 
 }
