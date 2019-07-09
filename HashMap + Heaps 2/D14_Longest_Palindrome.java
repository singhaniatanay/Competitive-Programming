import java.util.*;

public class D14_Longest_Palindrome {
    public static int longestPalindrome(String s) {
        //Write your code here
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int len=0;
        for(Integer i:map.values()){
            if(i%2==0)
                len+=i;
            else{
                len+=i-1;
            }
        }
        return len+1;
    }

    //Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(longestPalindrome(str));

    }

}