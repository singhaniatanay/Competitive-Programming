import java.util.*;

public class D17_Split_Array_With_Equal_Sum{

    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scn.nextInt();
        }
        System.out.print(splitArray(nums));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array
    // It should return a boolean value.
    public static boolean splitArray(int[] nums) {
        //Write your code here
        if(nums.length<7){
            return false;
        }
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        int sum=nums[0];
        for(int i =1;i<=nums.length-6;i++){
            Queue<Integer> q = map.getOrDefault(sum,new LinkedList<>());
            q.add(i);
            map.put(sum,q);
            sum+=nums[i];
        }
        sum=nums[nums.length-1];
        int k=nums.length-2;
        while (k>=5){
            if(map.containsKey(sum)){
                Queue<Integer> q = map.get(sum);
                while (!q.isEmpty()){
                    int possible_i = q.remove();
                    int temp_k=k;
                    int leftSum=0;
                    int rightSum=0;
                    while (possible_i<=temp_k){
                        possible_i++;
                        leftSum+=nums[possible_i];
                        temp_k--;
                        rightSum+=nums[temp_k];
                        if(leftSum==rightSum &&leftSum==sum){
                            return true;
                        }
                    }

                }
            }
            sum+=nums[k];
            k--;
        }
        return false;
    }
}