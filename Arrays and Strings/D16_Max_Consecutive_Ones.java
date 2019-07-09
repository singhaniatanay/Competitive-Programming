import java.util.*;

public class D16_Max_Consecutive_Ones {

    // This is a functional problem. You have to complete this function.
    // It takes as input a binary array. It should return the maximum number
    // of consecutive 1s in this array if you can flip at most one 0.
    public static int findMaxConsecutiveOnes(int[] nums) {
        // write your code here.
        int st=0;
        int len=0;
        int zeroes =0;
        for (int i = 0; i <nums.length ; i++) {
            //acquire
            if(nums[i]==0){
                zeroes++;
            }
            while (zeroes>1){
                if(nums[st]==0){
                    zeroes--;
                }
                st++;
            }
            len = Math.max(len,i-st+1);
        }

        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[] arr1 = new int[N];

        // Input for array1 elements.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int result = findMaxConsecutiveOnes(arr1);

        System.out.println(result);

    }

    // Function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}