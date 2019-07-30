/*
Given a byte, swap the two nibbles in it.
For example 100 is be represented as 01100100
in a byte (or 8 bits). The two nibbles are (0110) and (0100).
If we swap the two nibbles, we get 01000110 which is 70 in decimal.
*/

import java.util.Scanner;

public class D35_SwitchNibbles {
    public static void main (String[] args)
    {

        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = in.nextInt();
            int a = n / 16;
            int b = n % 16;
            System.out.println(b * 16 + a);
        }


    }
}
