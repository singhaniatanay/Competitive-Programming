import java.util.*;

public class D16_Squares_Of_Sorted_Array {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return
    // the required array.
    public static int[] sortedSquares(int[] A) {
        // write your code here.
        int left=0;
        int right=A.length-1;
        int ans[]= new int[A.length];
        int i=A.length-1;
        while(left<=right){
            int lVal = A[left]*A[left];
            int rVal = A[right]*A[right];
            if(lVal<rVal){
                ans[i--] = rVal;
                right--;
            }else{
                ans[i--] = lVal;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of array.
        int length = sc.nextInt();

        int[] arr = new int[length];

        // Input for elements of array.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = sortedSquares(arr);
        display(result);

    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}