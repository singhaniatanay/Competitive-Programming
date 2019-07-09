import java.util.*;
import java.io.*;

public class D11_gap_btw_highest_lowest_occurence {

    public static void findDifference(int[] arr) {
        //Write your code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)>max){
                max = map.get(i);
            }
            if(map.get(i)<min){
                min = map.get(i);
            }
        }
        System.out.println(max-min);
    }

    //Don't make any changes here
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        findDifference(num);
    }
}