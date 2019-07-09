import java.util.*;

public class D14_top_k_frequent_words {


    public static ArrayList<String> topKFrequent(String[] words, int k) {
        //Write your code here
        HashMap<String,Integer> map = new HashMap<>();
        for(String i:words)
            map.put(i,map.getOrDefault(i,0)+1);
        ArrayList<String> ans = new ArrayList<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(new PQComparator()));
        for(Map.Entry<String,Integer> i:map.entrySet()){
            pq.add(i);
        }
        while (k>0) {
            ans.add(pq.remove().getKey());
            k--;
        }
        return ans;

    }
    public static class PQComparator implements Comparator<Map.Entry<String,Integer>>{
        public int compare(Map.Entry<String,Integer> one,Map.Entry<String,Integer> two){
            return one.getValue()-two.getValue();
        }
    }

    //Don't make any changes here
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.next();
        }
        int k = s.nextInt();
        ArrayList<String> res = topKFrequent(array, k);
        Collections.sort(res);
        System.out.println(res);

    }






}