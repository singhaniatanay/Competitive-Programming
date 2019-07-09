import java.util.*;

public class D13_find_k_pairs_with_smallest_sums {

    // This is a functional problem. You have to complete this function.
    // It takes as input two arrays and k.
    // It should return list of k lists of pairs with smallest sum.
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // write your code here.
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        while(k>0){
            int one = nums1[i];
            int two = nums2[j];
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(one);
            pair.add(two);
            result.add(pair);
            if(one<two){
                //retain one
                j++;
            }else{
                i++;
            }
            k--;
        }
        return result;

//        HashMap<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<>();
//        for (int i = 0; i <nums1.length ; i++) {
//            int one = nums1[i];
//            for (int j = 0; j <nums2.length ; j++) {
//                int two = nums2[i];
//                ArrayList<Integer> pair = new ArrayList<>();
//                pair.add(one);
//                pair.add(two);
//                ArrayList<ArrayList<Integer>> pairs = map.getOrDefault(one+two,new ArrayList<>());
//                pairs.add(pair);
//                map.put(one+two,pairs);
//            }
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
//        Collections.sort(keys);
//        for(Integer key:keys){
//            if(k==0){
//                break;
//            }else {
//                ArrayList<ArrayList<Integer>> a = map.get(key);
//                for (ArrayList<Integer> i : a) {
//                    result.add(i);
//                    k--;
//                    if(k==0){
//                        break;
//                    }
//                }
//            }
//        }
//        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[] arr1 = new int[N];

        // Input for array1 elements.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input for length of second array.
        int M = sc.nextInt();

        int[] arr2 = new int[M];

        // Input for array2 elements.
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        List<List<Integer>> result = kSmallestPairs(arr1, arr2, K);
        //result.sort(new ListComparator());

        display(result);

    }

    // Comparator for sorting the result list.
    static class ListComparator implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {

            int sum1 = l1.get(0) + l1.get(1);
            int sum2 = l2.get(0) + l2.get(1);

            if (sum1 != sum2) {
                return sum1 - sum2;
            } else {
                return l1.get(0) - l2.get(0);
            }

        }
    }

    // Function to display a List of Lists of integers.
    public static void display(List<List<Integer>> list) {

        for (int i = 0; i < list.size(); i++) {

            List<Integer> currList = list.get(i);

            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }

            System.out.println();
        }

    }

}