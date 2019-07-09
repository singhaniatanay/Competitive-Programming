import java.util.*;
import java.io.*;

public class D14_Longest_SubArr_With_Sum_K {

    public static void print(int n, int[] arr, int target) {
        //Write your code here
        int len = Integer.MIN_VALUE;
        int sum=0;
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        Queue<Integer> in = new LinkedList<>();
        in.add(-1);
        map.put(sum,in);
        for(int k=0;k<arr.length;k++){
            sum+=arr[k];
            Queue<Integer> indexes = map.getOrDefault(sum,new LinkedList<Integer>());
            indexes.add(k);
            map.put(sum,indexes);
            if(map.containsKey(sum-target)){
                len = len>k-map.get(sum-target).peek()?len:k-map.get(sum-target).peek();
            }


        }
        System.out.println(len);

    }

    //Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.nextInt();
        }
        print(n, num, k);
    }


}