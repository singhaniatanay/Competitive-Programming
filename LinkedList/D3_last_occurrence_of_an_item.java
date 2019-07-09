import java.util.*;
 
 public class D3_last_occurrence_of_an_item {
 
     // -----------------------------------------------------
     // This is a functional problem. You have to complete this function.
     // This function takes as input the head of the linked list and key.
     // It should return the head of the modified list.
 
     public static Node func(Node head, int key) {
         
         head = reverseLL(head);
         Node prev = null;
         Node curr = head;
         if(curr.data==key){
             head = head.next;
             return reverseLL(head);
         }
         while(curr!=null){
             if(curr.data==key){
                 prev.next = curr.next;
                 break;
             }
             prev = curr;
             curr = curr.next;
         }
         return reverseLL(head);
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
 
         int k = sc.nextInt();
         head1 = func(head1, k);
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
 
         System.out.println();
     }
 
 }
