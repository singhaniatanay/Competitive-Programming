import java.util.*;

class D19_Three_Sum_CLoser{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scn.nextInt();
        }
        int k=scn.nextInt();
        System.out.print(threeSumClosest(nums,k));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array and an integer
    // It should return an integer value.

    public static int threeSumClosest(int[] nums, int target) {
        //Write your code here
        Arrays.sort(nums);
        int min=0;
        HashSet<List<Integer>> ans = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum)<target-min){
                    min = sum;
                    j++;
                    k--;
                }else if(nums[j]+nums[k]<target-nums[i]){
                    j++;
                }else {
                    k--;
                }
            }
        }

        return min;
    }

}