import java.util.ArrayList;
import java.util.Scanner;

public class D16_Product_Of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        //Write your code here.
        double[] arr = new double[nums.length];
        double sum=0;
        for(int i=0;i<nums.length;i++){
            arr[i] = Math.log(nums[i]);
            sum+=arr[i];
        }
        for(int i=0;i<arr.length;i++){
            nums[i] = (int)Math.round(Math.exp(sum-arr[i]));
        }
        return nums;

    }

    //Don't make changes here.
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int Input[] = new int[n];
        for (int i = 0; i < n; i++) {
            Input[i] = scn.nextInt();
        }
        int ans[] = productExceptSelf(Input);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}