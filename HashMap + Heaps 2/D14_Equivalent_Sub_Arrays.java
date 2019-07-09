import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class D14_Equivalent_Sub_Arrays {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int[n];
        for(int  i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        System.out.println(val(arr));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array
    // It should return an integer value.
    public static int val(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr)
            set.add(i);
        int k = set.size();
        set.clear();
        int windowK=0;
        int right=0;
        int count=0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while(right<arr.length && windowK<k){
                if(!map.containsKey(arr[right])){
                    windowK++;
                }
                map.put(arr[right],map.getOrDefault(arr[right],0)+1);
                right++;
            }
            if(windowK==k){
                count += arr.length-right+1;
            }

            map.put(arr[i],map.getOrDefault(arr[i],0)-1);
            if(map.get(arr[i])==0){
                map.remove(arr[i]);
                windowK--;
            }
        }

        return count;
    }
}