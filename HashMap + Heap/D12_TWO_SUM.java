import java.util.*;

public class D12_TWO_SUM {


    public static ArrayList<Integer> twoSum(ArrayList<Integer> nums, int target) {
        //Write your code here
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            Queue<Integer> indexes = map.getOrDefault(nums.get(i),new LinkedList<>());
            indexes.add(i);
            map.put(nums.get(i),indexes);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer i:map.keySet()){
            if(map.containsKey(target-i)){
                ans.add(map.get(i).remove());
                ans.add(map.get(target-i).remove());
            }
        }
        return ans;

    }

    //Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            nums.add(s.nextInt());
        }
        int target = s.nextInt();
        System.out.println(twoSum(nums, target));

    }


}