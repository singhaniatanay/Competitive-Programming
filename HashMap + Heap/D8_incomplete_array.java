import java.util.*;

public class D8_incomplete_array {// -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.

    public static int incomplete(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            min = Integer.min(min, i);
            max = Integer.max(max, i);
            set.add(i);
        }

        return (max-min+1)-set.size();
    }

    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(incomplete(arr));
    }
}