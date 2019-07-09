import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class D12_SMALLEST_WINDOW_IN_STR_CONTAINING_ALL_CHAR_OF_ANOTHER {

    public static String smallestWindow(String s,String r){

        int matchCount=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < r.length(); i++) {
            map.put(r.charAt(i),map.getOrDefault(r.charAt(i),0)+1);
        }
        int st=0;
        int end=s.length()-1;
        HashMap<Character,Integer> set = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if(matchCount==map.size()){
                while (!set.containsKey(s.charAt(st)) || (set.get(s.charAt(st))>1)){
                    if(set.containsKey(s.charAt(st))){
                        set.put(s.charAt(st),set.get(s.charAt(st)));
                    }
                    st++;
                }
                if(i-st<end-st){
                    end = i;
                }
            }
            //acquire
            if(map.containsKey(s.charAt(i))){
                if(!set.containsKey(s.charAt(i))){
                    matchCount++;
                    set.put(s.charAt(i),1);
                }else{
                    set.put(s.charAt(i),set.get(s.charAt(i))+1);
                }
            }
        }
        return s.substring(st,end+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String r =sc.next();
        System.out.println(smallestWindow(s,r));
    }

}
