import java.util.Scanner;

public class D1_arrange_vowels_and_consonants{

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char h = sc.next().charAt(0);
        insert(h);

        for (int i = 1; i < n; i++) {
            char ch = sc.next().charAt(0);
            insert(ch);
        }

        head = arcv(head);
        display();

    }

    //---------------------------------------------------------------
    //This is a functional problem. Only this function has to be written.
    // This function should return the head of node after sorting.
    public static Node arcv(Node head) {
        Node vowel = null;
        Node vt = null;
        Node consonant = null;
        Node ct = null;
        while(head!=null){
            if(isVowel(head.data)){
                if(vowel==null){
                    vowel = new Node(head.data,null);
                    vt = vowel;
                }else{
                    vt.next = new Node(head.data,null);
                    vt = vt.next;
                }
            }
            else{
                if(consonant==null){
                    consonant = new Node(head.data,null);
                    ct = consonant;
                }else{
                    ct.next = new Node(head.data,null);
                    ct = ct.next;
                }
            }

            head = head.next;
        }
        if(vowel!=null)
            vt.next = consonant;
        else
            return consonant;
        return vowel;

    }
    public static boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;

        return false;
    }
    //------------------------------------------------------------------


    private static class Node {
        char data;
        Node next;

        public Node(char data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    static Node head;
    static Node tail;
    static int size;

    public static void insert(char data) {

        Node nn = new Node(data, null);
        if (head == null) {
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
        size++;
    }

    public static void display() {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data+" ");
        }
    }

}