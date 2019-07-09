import java.lang.*;
import java.io.*;
import java.util.*;

class D14_Largest_Fibonaci_SubSeq {

    public static void solve(int[] arr) {
        //Write your code here
        int max=0;
        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        ArrayList<Integer> fibb = new ArrayList<>();
        fibb.add(0);
        fibb.add(1);
        int sum=0;
        while(sum<=max){
             sum = fibb.get(fibb.size()-2)+fibb.get(fibb.size()-1);
             fibb.add(sum);
        }
        for(int i:arr){
            if(fibb.contains(i)){
                System.out.print(i+" ");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        solve(num);
    }

}