import java.util.HashSet;
import java.util.Scanner;

public class D14_LONGEST_SUBSTRING_WITHOUT_REPEATING_CHAR {
    public static int lengthOfLongestSubstring(String s) {
        //Write your code here
        HashSet<Character> set = new HashSet<>();
        char[] ss = s.toCharArray();
        for(char i:ss){
            set.add(i);
        }
        int max = set.size();
        int len=Integer.MIN_VALUE;
        set.clear();
        int st = 0;
        for(int i=0;i<ss.length;i++){
            if(set.contains(ss[i])){
                //settle
                while(set.contains(ss[i])){
                    set.remove(ss[st]);
                    st++;
                }

            }
            set.add(ss[i]);
            if(i-st+1>len){
                len = i-st+1;
            }
            if(len==max)
                return max;
        }
        return len;


    }
    //Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(lengthOfLongestSubstring(str));

    }

}