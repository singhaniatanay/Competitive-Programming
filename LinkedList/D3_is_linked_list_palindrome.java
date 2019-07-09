import java.util.Scanner;
 
 public class D3_is_linked_list_palindrome {
 
     static Node left;
 
     // -----------------------------------------------------
     // This is a functional problem. You have to complete this function.
     // This function takes as input the head of the linked list.
     // It should return true if list is palindrome, else return false.
 
     public static boolean isPalindrome(Node head) {
         
         Node[] twoNodes = split(head);
         Node n1 = twoNodes[0];
         Node n2 = reverseLL(twoNodes[1]);
         
         while(n2!=null){
             if(n1.data!=n2.data){
                 return false;
             }
             n1=n1.next;
             n2=n2.next;
         }
         return true;
         
         
     }
     
     
     
     static Node[] split(Node head){
         Node slow=head;
         Node prev=null;
         Node fast=head;
         
         while(fast!=null&&fast.next!=null){
             prev=slow;
             slow=slow.next;
             fast=fast.next.next;
         }
        if(fast!=null){
            prev=slow;
            slow=slow.next;
        }
        prev.next=null;
        return new Node[]{head,slow};
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
 
         if (isPalindrome(head1)) {
             System.out.println("1");
         } else {
             System.out.println("0");
         }
 
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
      * Input Parameters: tail: head of the linked list in which a new node is to
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
