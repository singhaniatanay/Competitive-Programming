import java.util.*;

public class D21_Min_Deletions_to_make_sorted {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scn.nextInt();
        mindeletions(a, n);
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array and its length
    // It should print the required output

    public static void mindeletions(int[] a, int n)
    {
        // Write your code here
        System.out.println(a.length-LongestIncreasingSequence(a));
    }
    public static int LongestIncreasingSequence(int a[]){
        int[] arr = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            if(i==0) {
                arr[i] = 1;
                continue;
            }
            int max=0;
            for (int j = 0; j < i; j++) {
                if(a[j]<=a[i]){
                    //jod skte hai
                    max = Math.max(arr[j],max);
                }
            }
            arr[i] = max+1;
        }

        int maximum=Integer.MIN_VALUE;
        for(int x:arr){
            if(x>maximum)
                maximum=x;
        }
        return maximum;
    }
}