import java.util.*;

public class D14_kth_largest_in_a_stream {

    // This is a functional problem. You have to complete this class.
    static class KthLargest {
        public ArrayList<Integer> list;
        public int k;
        public KthLargest(int k, int[] nums) {
            // write your code here.
            this.k=k;
            list = new ArrayList<>();
            for(int i:nums){
                list.add(i);
            }
            Collections.sort(list,Collections.reverseOrder());
        }

        public int add(int val) {
            // write your code here.
            list.add(val);
            Collections.sort(list,Collections.reverseOrder());
            return list.get(k-1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[] intialStream = new int[N];

        // Input for initial stream elements.
        for (int i = 0; i < intialStream.length; i++) {
            intialStream[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        int M = sc.nextInt();
        int[] remainingStream = new int[M];

        // Input for remaining stream elements.
        for (int i = 0; i < remainingStream.length; i++) {
            remainingStream[i] = sc.nextInt();
        }

        KthLargest obj = new KthLargest(K, intialStream);

        for (int i = 0; i < remainingStream.length; i++) {
            int kthLargest = obj.add(remainingStream[i]);
            System.out.println(kthLargest);
        }

    }

    // Function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}