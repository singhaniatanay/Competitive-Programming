import java.util.*;

public class D14_top_k_frequent {


    public static ArrayList<Integer> topKFrequent(int n, int[] nums, int k) {
        //Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(new PQComparator()));
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            pq.add(i);
        }
        while (k>0) {
            ans.add(pq.remove().getKey());
            k--;
        }
        return ans;

    }
    public static class PQComparator implements Comparator<Map.Entry<Integer,Integer>>{
        public int compare(Map.Entry<Integer,Integer> one,Map.Entry<Integer,Integer> two){
            return one.getValue()-two.getValue();
        }
    }

    //Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        int k = s.nextInt();
        ArrayList<Integer> res = topKFrequent(n, ar, k);
        Collections.sort(res);
        System.out.println(res);
    }

}