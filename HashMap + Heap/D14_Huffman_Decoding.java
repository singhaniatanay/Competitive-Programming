import java.util.*;
import java.io.*;

public class D14_Huffman_Decoding {
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.

    static HashMap<String, Character> map = new HashMap<>();

    private static String decodeString(minHeapNode root, String encodedStr) {

        printCode(root, "");

        String ans = "";
        String code = "";
        for (char c : encodedStr.toCharArray()) {
            code += c;
            if (map.containsKey(code)) {
                ans += map.get(code);
                code = "";
            }
        }
        return ans;
    }

    private static void printCode(minHeapNode node, String code) {
        if (node.left == null && node.right == null) {
            map.put(code, node.data);
            return;
        }
        printCode(node.left, code + "0");
        printCode(node.right, code + "1");
    }

    // -----------------------------------------------------

    static class minHeapNode {
        char data;
        int freq;
        minHeapNode left, right;

        minHeapNode(char data, int freq) {
            left = right = null;
            this.data = data;
            this.freq = freq;
        }
    }

    static class heapComparator implements Comparator<minHeapNode> {
        public int compare(minHeapNode h1, minHeapNode h2) {
            if (h1.freq < h2.freq) {
                return 1;
            } else if (h1.freq > h2.freq) {
                return -1;
            }
            return 0;
        }
    }

    static PriorityQueue<minHeapNode> heapq;
    static HashMap<Character, Integer> freqMap;
    static HashMap<Character, String> codes;

    static void storeCodes(minHeapNode root, String str) {
        if (root == null)
            return;
        if (root.data != '$')
            codes.put(root.data, str);
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }

    static void encodeString() {
        minHeapNode left, right, top;
        for (Map.Entry<Character, Integer> val : freqMap.entrySet()) {
            heapq.add(new minHeapNode(val.getKey(), val.getValue()));
        }
        while (heapq.size() != 1) {
            left = heapq.poll();
            right = heapq.poll();
            top = new minHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            heapq.add(top);
        }
        storeCodes(heapq.peek(), "");
    }

    static void calcFreq(String str) {
        for (int i = 0; i < str.length(); i++) {
            Integer j = freqMap.get(str.charAt(i));
            freqMap.put(str.charAt(i), (j == null) ? 1 : j + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        heapq = new PriorityQueue<minHeapNode>(new heapComparator());
        codes = new HashMap<Character, String>();
        freqMap = new HashMap<Character, Integer>();
        String encodedString = "";
        calcFreq(str);
        encodeString();
        for (int i = 0; i < str.length(); i++) {
            encodedString += codes.get(str.charAt(i));
        }
        System.out.println(decodeString(heapq.peek(), encodedString));
    }
}