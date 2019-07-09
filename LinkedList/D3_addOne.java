import java.util.*;
 
 public class D3_addOne {
 
     // -----------------------------------------------------
     // This is a functional problem. You have to complete this function.
     // It takes as input the head of the linked list. It should return the
     // head of the modified linked list.
 
     public static Node plusOne(Node n) {
         
         
         Node nn=reverseLL(n);
         Node temp = nn;
         int carry=1;
         int data=0;
         while(nn!=null){
             data = nn.data+carry;
             carry = data/10;
             nn.data = (carry==0)?data:data%10;
             nn=nn.next;
         }
         if(carry==1){
             Node newNode = new Node(1);
             temp = reverseLL(temp);
             newNode.next = temp;
             return newNode;
             
         }
         
         return reverseLL(temp);
         
         
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
 
         head1 = plusOne(head1);
         display(head1);
 
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
      * Input Parameters: tail: tail of the linked list in which a new node is to
      * be inserted. data: the data value of the node which is to be inserted.
      * 
      * Return Value: tail of the linked list/the node that is inserted
      */
     public static Node insert(Node tail, int data) {
 
         if (tail == null) {
             return new Node(data);
         }
 
         Node nn = new Node(data);
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
     }
 
 }
