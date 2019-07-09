import java.util.*;

public class D17_Buy_Stock_Sell_Stock_V2 {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return the maximum profit.
    public static int maxProfit(int[] A) {
        // write your code here.
        int profit=0;
        for (int i = 1; i < A.length; i++) {
            int temp = A[i]-A[i-1];
            if(temp<0){
                continue;
            }
            profit+=temp;
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxProfit(arr));
    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}