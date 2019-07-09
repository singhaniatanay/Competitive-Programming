import java.io.*;
import java.util.*;

public class D11_distinct_elements_in_a_stream {
    public static void print(String[] arr) throws IOException {
        //  Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(String i : arr){
            Integer k = Integer.parseInt(i.substring(2));
            if(i.charAt(0)=='A'){
                //Addition
                map.put(k,map.getOrDefault(k,0)+1);
            }
            if(i.charAt(0)=='R'){
                //Remove/Delete
                if(map.containsKey(k)) {
                    map.put(k, map.getOrDefault(k, 0) - 1);

                    if (map.get(k) == 0) {
                        map.remove(k);
                    }
                }
            }
            System.out.println(map.keySet().size());
        }

    }
    //Don't make any changes here
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        print(arr);

    }



}