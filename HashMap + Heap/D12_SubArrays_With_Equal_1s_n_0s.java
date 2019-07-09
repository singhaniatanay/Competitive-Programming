import java.util.*;

public class D12_SubArrays_With_Equal_1s_n_0s {

    public static int countSubArrays(int[] a, int n) {
        //Write your code here.
        for (int i = 0; i <a.length ; i++) {
            a[i] =  a[i]==0?-1:a[i];
        }
        return subArraySum(a,n,0);

    }
    static int subArraySum(int arr[], int n, int sum) {

        // write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sumTillNow=0;
        int count = 0;
        map.put(sumTillNow,1);
        for(int i:arr){
            sumTillNow+=i;
            count += map.getOrDefault(sumTillNow-sum,0);
            map.put(sumTillNow,map.getOrDefault(sumTillNow,0)+1);
        }
        HashSet<Integer> a = new HashSet<>();
        ArrayList<Integer> aa = new ArrayList<>(a);

        return count;



    }

    //Don't make any changes here.
    public static void main(String[] args) {
        // code
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(countSubArrays(a, n));

    }

}