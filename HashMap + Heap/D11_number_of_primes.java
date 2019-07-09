import java.util.*;

public class D11_number_of_primes {

    // This is a functional problem. You have to complete this function.
    // It takes as input N. It should return the count of prime numbers less
    // than N.
    public static int countPrimes(int n) {
        // write your code here.

        boolean[] bool = new boolean[n];
        Arrays.fill(bool,true);
        for (int i = 2; i < n; i++) {
            if(bool[i]) {
                for (int j = i; j < n; j += i) {
                    bool[j] = j==i;
                }
            }
        }
        int count=0;
        for (int i = 2; i <n ; i++) {
            count += bool[i]?1:0;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(countPrimes(N));

    }

}