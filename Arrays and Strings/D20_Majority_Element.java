import java.util.*;

class D20_Majority_Element {

    public static int majorityElement(int[] nums) {
        //Write your code here
        int possibleMajor=nums[0];
        int delta=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==possibleMajor) {
                delta++;
                continue;
            }else{
                delta--;
                if(delta==0){
                    possibleMajor=nums[i];
                    delta=1;
                }
            }
        }
        int count=0;
        for(int i:nums){
            if(i==possibleMajor)
                count++;
        }
        if(count>(nums.length/2))
            return possibleMajor;

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityElement(arr));
    }
}