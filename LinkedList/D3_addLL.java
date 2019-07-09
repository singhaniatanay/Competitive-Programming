import java.util.*;
 
 public class D3_addLL {
 
     // -----------------------------------------------------
     // This is a functional problem. You have to complete this function.
     // This function takes as input the head of two the linked lists.
     // It should return the head of the resultant list.
     public static Node addTwoNumbers(Node n1, Node n2) {
         
         Node node1 = reverseLL(n1);
         Node node2 = reverseLL(n2);
         int carry=0;
         int data=0;
         Node ans = null;
         
         while(node1!=null&&node2!=null){
             data = node1.data+node2.data+carry;
             carry = data/10;
             Node newNode = new Node((carry==0)?data:data%10,ans);
             ans=newNode;
             node1=node1.next;
             node2=node2.next;
         }
         
         while(node1!=null){
             data = carry + node1.data;
             carry = data/10;
             Node newNode = new Node((carry==0)?data:data%10,ans);
             ans = newNode;
             node1=node1.next;
         }
         while(node2!=null){
             data = carry + node2.data;
             carry = data/10;
             Node newNode = new Node((carry==0)?data:data%10,ans);
             ans = newNode;
             node2=node2.next;
         }
         
         if(carry==1&&node1==null&&node2==null){
             Node newNode = new Node(1,ans);
             return newNode;
             
         }
         
         
         return ans;
         
     }
     
     public static Node reverseLL(Node head){
         Node prev = null;
         Node curr = head;
         while(curr!=null){
             Node nex = curr.next;
             curr.next = prev;
             prev = curr;
             curr = nex;
         }
         return prev;
     }
 
 
     
     // -----------------------------------------------------
 
     static Node head1;
 
     static Node head2;
 
     static Node head3;
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n1 = sc.nextInt();
         int a1 = sc.nextInt();
 
         Node tail;
         head1 = tail = insert(null, a1);
 
         for (int i = 1; i < n1; i++) {
             int a = sc.nextInt();
             tail = insert(tail, a);
         }
 
         int n2 = sc.nextInt();
         int a2 = sc.nextInt();
 
         head2 = tail = insert(null, a2);
 
         for (int i = 1; i < n2; i++) {
             int a = sc.nextInt();
             tail = insert(tail, a);
         }
 
         head3 = addTwoNumbers(head1, head2);
         display(head3);
 
     }
 
     // Class declaration for a Node of the Linked List
     private static class Node {
         int data;
         Node next;
 
         public Node(int data, Node next) {
             this.data = data;
             this.next = next;
         }
 
     }
 
     /*
      * Input Parameters: tail: head of the linked list in which a new node is to
      * be inserted. data: the data value of the node which is to be inserted.
      * 
      * Return Value: tail of the linked list/the node that is inserted
      */
     public static Node insert(Node tail, int data) {
 
         if (tail == null) {
             return new Node(data, null);
         }
 
         Node nn = new Node(data, null);
         tail.next = nn;
         return nn;
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
         System.out.println();
     }
 
 }
