import java.util.*;
import java.io.*;

public class D14_Longest_K_Unique_Substring {


    public static void print(String str, int k) {
        //Write your code here
        HashMap<Character,Integer> map = new HashMap<>();
        int len=0;
        int st=0;
        int uniqueUptilNow=0;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            if (map.size() == k + 1) {
                //release

                while (map.size() != k) {
                    map.put(str.charAt(st), map.get(str.charAt(st)) - 1);
                    if (map.get(str.charAt(st)) == 0) {
                        map.remove(str.charAt(st));
                    }
                    st++;
                }
            }
            if (map.size() == k)
                len = len < i - st + 1 ? i - st + 1 : len;
        }
            System.out.println(len);
        }


    //Don't make any changes here.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        print(s, k);
    }


}