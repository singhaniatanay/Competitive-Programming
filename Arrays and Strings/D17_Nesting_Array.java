import java.util.*;

class D17_Nesting_Array{

    public static int arrayNesting(int[] nums) {
        //Write your code here
        HashSet<Integer> visited_indexes = new HashSet<>();
        int i=0;
        int maxlen=0;
        int len=0;
        while (visited_indexes.size()!=nums.length){
            if(visited_indexes.contains(i)){
                maxlen = len>maxlen?len:maxlen;
                len=0;
                i++;
                continue;
            }
            int togo_index = nums[i];
            visited_indexes.add(i);
            len++;
            i=togo_index;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(arrayNesting(arr));
    }
}