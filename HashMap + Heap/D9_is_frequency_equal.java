import java.util.*;
import java.io.*;

public class D9_is_frequency_equal {


    public static boolean isFrequencyEqual(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Integer[] arr = map.values().toArray(new Integer[map.size()]);
        HashSet<Integer> set = new HashSet<>(map.values());
        if (set.size() > 2) {
            return false;
        }
        if (set.size() == 1) {
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int maxcount=0;
        int mincount=0;
        for (int x : map.values()) {
            if(x==max){
                maxcount++;
            }
            if (x==min){
                mincount++;
            }
        }
        if(maxcount>1){
            return false;
        }
        if(mincount==1&&min==1){
            return true;
        }
        if (max - min != 1) {
            return false;
        }

        return true;
    }

    //Don't make any changes here
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean bl = isFrequencyEqual(s);
        System.out.println(bl);
    }
}