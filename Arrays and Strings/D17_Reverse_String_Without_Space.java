import java.util.Scanner;

public class D17_Reverse_String_Without_Space {
    public static void reverseString(char[] s) {
        //Write your code here
        int left=0;
        int right=s.length-1;
        while ((left<=right)){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }

    //Don't make any changes here.
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        char[] charArray = new char[n];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = scn.next().charAt(0);
        }

        reverseString(charArray);

        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }

    }

}