import java.util.*;

class D17_Three_Sum{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scn.nextInt();
        }
        System.out.print(threeSum(nums));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array
    // It should return an required output
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            int num = -nums[i];
            while (j<k){
                if(nums[j]+nums[k]==num){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                }else if(nums[j]+nums[k]<num){
                    j++;
                }else {
                    k--;
                }
            }
        }
        ArrayList<List<Integer>> ll = new ArrayList<>(ans);
        Collections.sort(ll, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0)-o2.get(0)!=0)
                    return o1.get(0)-o2.get(0);
                else if(o1.get(1)-o2.get(1)!=0)
                    return o1.get(1)-o2.get(1);

                return o1.get(2)-o2.get(2);
            }
        });
        return ll;
    }
}