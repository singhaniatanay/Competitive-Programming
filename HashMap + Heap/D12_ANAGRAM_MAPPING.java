import java.util.*;

public class D12_ANAGRAM_MAPPING {

    public static int[] anagramMappings(int[] A, int[] B) {
        //Write your code here
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<B.length;i++){
            Queue<Integer> indexes = map.getOrDefault(B[i],new LinkedList<>());
            indexes.add(i);
            map.put(B[i],indexes);
        }
        int[] P = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int curr = A[i];
            Queue<Integer> indexes = map.get(curr);
            P[i] = indexes.remove();
            map.put(curr,indexes);
        }
        return P;
    }

    //Don't make any changes here
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
        }
        int[] res = anagramMappings(a, b);
        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }

    }

}