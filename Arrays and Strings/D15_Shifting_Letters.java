import java.util.*;

public class D15_Shifting_Letters {

    // This is a functional problem. You have to complete this function.
    // It takes as input a String S and an integer array shifts.
    // It should return the final string after all the shifts are applied.
    public static String shiftingLetters(String S, int[] shifts) {
        // write your code here.
        int shift=0;
        String ans = "";
        for(int i=shifts.length-1;i>=0;i--){
            shift+=shifts[i];
            ans = ((char)(((S.charAt(i)-'a')+shift%26)%26 +'a'))+ans;
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        int N = sc.nextInt();

        int[] shifts = new int[N];

        for (int i = 0; i < N; i++) {
            shifts[i] = sc.nextInt();
        }

        System.out.println(shiftingLetters(S, shifts));
    }
}