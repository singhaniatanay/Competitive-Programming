import java.util.*;

public class D16_Shortest_n_Unsorted_SubArray {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return
    // the length of the shortest continuous subarray.
    public static int findUnsortedSubarray(int[] a) {

        int[] minarr = new int[a.length];
        int[] maxarr = new int[a.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            maxarr[i] = max;
        }
        for (int i = a.length - 1; i >= 0; i--) {
            min = Math.min(min, a[i]);
            minarr[i] = min;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < a.length; i++) {
            if (minarr[i] != maxarr[i]) {
                start = i;
                break;
            }
        }
        for (int i = a.length - 1; i >= 0; i--) {
            if (minarr[i] != maxarr[i]) {
                end = i;
                break;
            }
        }
        if (start == -1 && end == -1) {
            return 0;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of array.
        int length = sc.nextInt();

        int[] arr = new int[length];

        // Input for elements of array.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findUnsortedSubarray(arr));

    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}