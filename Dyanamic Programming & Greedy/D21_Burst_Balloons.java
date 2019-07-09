import java.util.*;


public class D21_Burst_Balloons {
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=scn.nextInt();
        System.out.println(maxCoins(nums));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array
    // It should return the required output

    public static int maxCoins(int[] nums) {
        //Write your code here
        int[][] dp = new int[nums.length][nums.length];

        for (int gap = 0; gap < nums.length ; gap++) {
            for (int i=0,j = i+gap; j <nums.length ; j++,i++) {
                //i,j denote sub array of i,j index mai max
                for (int k = i; k <=j ; k++) {
                    int left =  i - 1 < 0 ? 1 : nums[i - 1];
                    int right = j + 1 >= nums.length ? 1 : nums[j + 1];
                    int coins = left * nums[k] * right;
                    int beforeK = 0;
                    int afterK = 0;
                    if(i<k)
                        beforeK = dp[i][k-1];
                    if(j>k)
                        afterK = dp[k+1][j];

                    dp[i][j] = Math.max(dp[i][j],coins+beforeK+afterK);
                }
            }
        }
        return dp[0][nums.length-1];
    }

}