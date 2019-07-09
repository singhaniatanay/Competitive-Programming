import java.util.*;
import java.io.*;

class D14_Longest_Consecutive_Sub_Seq {

    public static int consecuitveSub(int n, int[] arr) {
        //Write oyur code here
        HashSet<Integer> set = new HashSet<>();
        for(int i :arr){
            set.add(i);
        }
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]-1)){
                continue;
            }else{
                //this may be the starting point
                int len=0;
                int j=arr[i];
                while(set.contains(j)){
                    j++;
                    len++;
                }
                max = max<len?len:max;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(consecuitveSub(n, num));

    }

}