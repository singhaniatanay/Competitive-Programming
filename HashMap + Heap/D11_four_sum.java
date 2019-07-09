import java.util.*;

public class D11_four_sum {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.

    private static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

        // write your code here
        Arrays.sort(nums);
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            ArrayList<Integer> indexes = map.getOrDefault(nums[i],new ArrayList<>());
            indexes.add(i);
            map.put(nums[i],indexes);
        }
        ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> currans;
            for(int j=i+1;j<nums.length-1;j++){
                int sum = nums[i]+nums[j];
                int sum_needed = target-sum;
                for (int k = j+1; k < nums.length; k++) {
                    if(map.containsKey(sum_needed-nums[k])){
                        //found ans
                        int lastindex = -1;
                        for(int index:map.get(sum_needed-nums[k])){
                            if(index>k){
                                lastindex= index;
                            }
                        }
                        if(lastindex==-1){
                            continue;
                        }
                        currans = new ArrayList<>();
                        currans.add(nums[i]);
                        currans.add(nums[j]);
                        currans.add(nums[k]);
                        currans.add(sum_needed-nums[k]);
                        ans.add(currans);
                    }
                }
            }
        }
        return ans;
    }

    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);
        for (ArrayList<Integer> a : ans) {
            for (int element : a) {
                System.out.print(element + ",");
            }
            System.out.println();
        }

    }

}