import java.util.*;
import java.io.*;

public class D12_SUBARRAY_RANGE_WITH_GIVEN_SUM {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.

    static int subArraySum(int arr[], int n, int sum) {

        // write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sumTillNow=0;
        int count = 0;
        map.put(sumTillNow,1);
        for(int i:arr){
            sumTillNow+=i;
            map.put(sumTillNow,map.getOrDefault(sumTillNow,0)+1);
            count += map.getOrDefault(sumTillNow-sum,0);
        }
        return count;


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sum = scn.nextInt();
        int[] arr = new int[n];
        for (int z = 0; z < n; z++) {
            arr[z] = scn.nextInt();
        }
        System.out.println(subArraySum(arr, n, sum));
    }
}