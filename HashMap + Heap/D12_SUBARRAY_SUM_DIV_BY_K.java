import java.util.*;
import java.io.*;

public class D12_SUBARRAY_SUM_DIV_BY_K {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.

    public static int subarraysDivByK(int[] A, int K) {

        //write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sumTillNow=0;
        int count = 0;
        map.put(sumTillNow,1);
        for(int i:A){
            sumTillNow+=i<0?(i%K)+K:i%K;
            count += map.getOrDefault(sumTillNow%K,0);
            map.put(sumTillNow%K,map.getOrDefault(sumTillNow%K,0)+1);

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] arr = new int[n];
        for (int z = 0; z < n; z++) {
            arr[z] = scn.nextInt();
        }
        System.out.println(subarraysDivByK(arr, k));
    }
}