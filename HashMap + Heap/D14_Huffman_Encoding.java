import java.util.*;

public class D14_Huffman_Encoding {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.
    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.freq - o2.freq;
        }
    }
    private static void Huffman(String str, int[] arr) {
        //write your code here
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        for (int i = 0; i < str.length(); i++) {
            pq.add(new Node(str.charAt(i) + "", arr[i]));
        }
        while (pq.size() > 1) {
            Node n1 = pq.remove();
            Node n2 = pq.remove();
            Node nn = new Node(n1.data + n2.data, n1.freq + n2.freq);
            nn.left = n1;
            nn.right = n2;
            pq.add(nn);
        }
        Node root = pq.remove();
        printCode(root,"");


    }
    public static void printCode(Node root, String s) {

        if (root.left == null && root.right == null) {
            System.out.print(s+" ");
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
    static class Node {
        String data;
        int freq;
        Node left;
        Node right;

        Node(String data, int freq) {
            this.data = data;
            this.freq = freq;
            this.left = null;
            this.right = null;
        }
    }
    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        Huffman(str, arr);
    }
}