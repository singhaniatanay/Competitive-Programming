import java.util.*;
import java.lang.*;
import java.io.*;

class D14_IN_FIRST_BUT_SECOND {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextLong();
        }
        int m = scn.nextInt();
        long[] num2 = new long[m];
        for (int i = 0; i < m; i++) {
            num2[i] = scn.nextLong();
        }
        solve(num, num2, n, m);
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input two arrays and lengths.
    // It should print required output.
    public static void solve(long a[], long b[],int n, int m)
    {
        //Write your code here
        boolean[] arr = new boolean[a.length];
        Arrays.fill(arr,true);
        HashMap<Long,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<a.length;i++) {
            ArrayList<Integer> indexes = map.getOrDefault(a[i],new ArrayList<Integer>());
            indexes.add(i);
            map.put(a[i],indexes);
        }
        for(long i:b){
            if(map.containsKey(i)){
                ArrayList<Integer> indexes  = map.get(i);
                for(int j:indexes){
                    arr[j] = false;
                }
            }
        }

        for(int i=0;i<a.length;i++){
            if(arr[i]) {
                System.out.print(a[i] + " ");
            }
        }


    }
}