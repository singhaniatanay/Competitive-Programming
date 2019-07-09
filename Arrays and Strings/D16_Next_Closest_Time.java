import java.util.*;

public class D16_Next_Closest_Time {

    // This is a functional problem. You have to complete this function.
    // It takes as input a string representing a time.
    // It should return the next closest time.
    public static String nextClosestTime(String t) {
        // write your code here.
        int[] digits = new int[4];
        int j=0;
        for (int i = 0; i <t.length() ; i++) {
            if(t.charAt(i)==':')
                continue;
            digits[j] = t.charAt(i)-'0';
        }
        Arrays.sort(digits);
        String ans ="";
//        for (int i = t.length()-1; i>=0 ; i--) {
//
//        }
        return "";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        System.out.println(nextClosestTime(time));

    }
}