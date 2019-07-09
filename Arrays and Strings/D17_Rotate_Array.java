
import java.util.Scanner;

public class D17_Rotate_Array {

    public static void rotate(int[] a, int k) {
        // Write your code here
            while(k>0){
                int prev=a[0];
                for(int i=1;i<a.length;i++){
                    int temp = a[i];
                    a[i] = prev;
                    prev = temp;
                }
                a[0] = prev;
                k--;
            }



    }

    // Don't make any changes here
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k=s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = s.nextInt();
        }
        rotate(ar, k);
        for (int v : ar)
            System.out.print(v + " ");
    }

}