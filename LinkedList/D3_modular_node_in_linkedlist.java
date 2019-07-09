import java.util.*;
 
 public class D3_modular_node_in_linkedlist {
 
     // -----------------------------------------------------
     // This is a functional problem. You have to complete this function.
     // It takes as input the head of the linked list and k.
     // It should return the data value of modular node.
     public static int moduarNode(Node head, int k) {
         
         int modular = -1;
         for(Node temp = head;temp!=null;temp=temp.next){
             if(temp.data%k==0){
                 modular = temp.data;
             }
         }
         
         return modular;
         
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
 
         System.out.println(moduarNode(head1, k));
 
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
