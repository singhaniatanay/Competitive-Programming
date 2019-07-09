import java.util.*;
import java.lang.*;
import java.io.*;

class D14_Largest_Subarray_with_0_Sum {

    static int maxLen(int arr[], int n) {
        //Write your code here
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(-1);
        int len=0;
        int sum=0;
        map.put(0,q);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            Queue<Integer> qq = map.getOrDefault(sum,new LinkedList<>());
            qq.add(i);
            map.put(sum,qq);
            len = len<i-map.get(sum).peek()?i-map.get(sum).peek():len;

        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxLen(arr, n));
    }
}