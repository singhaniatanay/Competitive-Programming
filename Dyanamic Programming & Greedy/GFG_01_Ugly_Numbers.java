import java.util.*;
/*
    Ugly numbers are numbers whose only prime factors
    are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8,
    9, 10, 12, 15, … shows the first 11 ugly numbers.
    By convention, 1 is included. Write a program to
    find Nth Ugly Number.

    Input:
    The first line of input contains an integer T
    denoting the number of test cases. T testcases
    follow. For each testcase there is one line of
    input that contains the number N.

    Output:
    Print the Nth Ugly Number.
*/
public class GFG_01_Ugly_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int largest = Integer.MIN_VALUE;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            largest = Math.max(arr[i], largest);
        }
        long[] tillLargest = getNthUglyNo(largest);
        for (int i : arr)
            System.out.println(tillLargest[i-1]);

    }

    public static long[] getNthUglyNo(int n) {
        long ugly[] = new long[n];  // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        long next_multiple_of_2 = 2;
        long next_multiple_of_3 = 3;
        long next_multiple_of_5 = 5;
        long next_ugly_no = 1;

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2) {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3) {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5) {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        } /*End of for loop (i=1; i<n; i++) */
        return ugly;
    }
}
