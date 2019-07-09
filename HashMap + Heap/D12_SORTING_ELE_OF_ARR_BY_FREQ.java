import java.util.*;

class D12_SORTING_ELE_OF_ARR_BY_FREQ {

    static void sortByFreq(int arr[], int n) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(Collections.reverseOrder(new mapComparator()));
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            priorityQueue.add(i);
        }


        while(!priorityQueue.isEmpty()){
            Map.Entry<Integer,Integer> curr = priorityQueue.remove();
            for (int j = 0; j < curr.getValue(); j++) {
                System.out.print(curr.getKey()+" ");
            }


        }


    }

    public static class mapComparator implements Comparator<Map.Entry<Integer,Integer>>{
        public int compare(Map.Entry<Integer,Integer> one,Map.Entry<Integer,Integer> two){
            Integer f1 = one.getValue();
            Integer f2 = two.getValue();
            if(f1==f2){
                return two.getKey()-one.getKey();
            }
            return f1-f2;
        }
    }

    //Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sortByFreq(arr, N);
    }
}