
import java.util.*;

public class D20_Longest_repeating_Character {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int k = scn.nextInt();
        System.out.println(characterReplacement(s, k));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array and integer k.
    // It should return required output.

    public static int characterReplacement(String s, int k) {
        // Write your code here
        int[] chars = new int[26];
        int maxCount=0;
        int maxSize=0;
        int st=0;
        for (int i = 0; i <s.length() ; i++) {
            chars[s.charAt(i)-'A']++;
            maxCount = Math.max(maxCount,chars[s.charAt(i)-'A']);
            while (i-st+1-maxCount>k){
                chars[s.charAt(st)-'A']--;
                maxCount = Math.max(maxCount,chars[s.charAt(st)-'A']);
                st++;
            }
            maxSize = i-st+1;
        }
        return maxSize;
    }
}