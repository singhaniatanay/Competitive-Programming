import java.util.ArrayList;
import java.util.Scanner;

//https://www.geeksforgeeks.org/super-ugly-number-number-whose-prime-factors-given-set/

public class GFG_02_Super_Ugly_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int largest = Integer.MIN_VALUE;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = getNthSuperUglyNo(arr,sc.nextInt());
        System.out.println(ans);

    }

    public static long getNthSuperUglyNo(int[] primes,int n) {
        //todo redo attempt it again

        long ugly[] = new long[n];  // To store ugly numbers
        int[] primeMult = new int[primes.length];
        long[] primesLong = new long[primes.length];
        int j=0;
        for (int i:primes)
            primesLong[j] = i;
        long next_ugly_no = 1;
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            next_ugly_no = Integer.MAX_VALUE;
            for(long prime:primesLong){
                next_ugly_no = Math.min(next_ugly_no,prime);
            }

            ugly[i] = next_ugly_no;
            for(int k=0;k<primesLong.length;k++){
                if(next_ugly_no==primesLong[k]){
                    primeMult[k]++;
                    primesLong[k] = ugly[primeMult[k]]*primes[k];
                }
            }
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no;
    }
}
