import java.util.*;

public class D12_SMALLEST_SUBARRAY_WITH_ALL_OCCURENCES_OF_MOST_FREQUENT_ELEMENT {

    public static void subarrAllOcc(int[] arr) {
        //Write your code here
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int maxIndexKey = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> indexes =map.getOrDefault(arr[i],new ArrayList<Integer>());
            indexes.add(i);
            if(indexes.size()>(map.getOrDefault(maxIndexKey,null)==null?0:map.get(maxIndexKey).size())){
                maxIndexKey = arr[i];
            }
            map.put(arr[i],indexes);
        }
        ArrayList<Integer> keys = map.getOrDefault(maxIndexKey,new ArrayList<Integer>());
        int firstindex = keys.get(0);
        int lastindex = keys.get(keys.size()-1);
        for (int i = firstindex; i <=lastindex ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //Dont make changes here
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        subarrAllOcc(arr);
    }
}