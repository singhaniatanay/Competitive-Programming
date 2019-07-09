import java.util.*;

public class D13_Valid_Anagram {

    // This is a functional problem. You have to complete this function.
    // It takes as input the String s ant t. It should return true if t is
    // and anagram of s, else should return false.

    public static boolean isAnagram(String s, String t) {
        // write your code here.
        char[] total = (s+t).toCharArray();
        int result = 0;
        for(char i:total){
            result ^= i;
        }
        return result==0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        if (isAnagram(s, t)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}