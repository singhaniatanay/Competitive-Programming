import java.util.*;

public class D13_Happy_Number {

    // This is a functional problem. You have to complete this function.
    // It takes as input a number n. It should return true if the number is
    // happy, else should return false.
    public static boolean isHappy(int n) {
        // write your code here.

        HashSet<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            int sum=0;
            set.add(n);
            while(n>0){
                int digit = n%10;
                sum += digit*digit;
                n = n/10;
            }
            n=sum;
        }

        return set.contains(1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (isHappy(N)) {
            System.out.println("Happy");
        } else {
            System.out.println("Not Happy");
        }
    }

}