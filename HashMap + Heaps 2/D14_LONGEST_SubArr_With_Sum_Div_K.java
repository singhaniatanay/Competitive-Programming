import java.io.*;
import java.util.*;

public class D14_LONGEST_SubArr_With_Sum_Div_K {

    public static void print(int n, int[] arr, int K) {
        //Write your code here
        int len = 0;
        int sum=0;
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        Queue<Integer> in = new LinkedList<>();
        in.add(-1);
        map.put(sum,in);
        for(int k=0;k<arr.length;k++){
            sum+=arr[k]%K;
            Queue<Integer> indexes = map.getOrDefault(sum%K,new LinkedList<Integer>());
            indexes.add(k);
            map.put(sum%K,indexes);
            if(map.containsKey(sum%K)){
                len = len>k-map.get(sum%K).peek()?len:k-map.get(sum%K).peek();
            }


        }
        System.out.println(len);
    }
    //Don't make any changes here.
    public static void main(String[] args) throws IOException {
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.nextInt();
        }
        int k = s.nextInt();
        print(n, num, k);
    }

}