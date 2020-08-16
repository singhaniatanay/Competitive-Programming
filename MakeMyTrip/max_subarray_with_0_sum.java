// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends




class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int[] a2 = new int[n];
        a2[0] = arr[0];
        for(int i=1;i<n;i++) a2[i] = a2[i-1] + arr[i];
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int i=0;i<n;i++){
            if(a2[i]==0){
                maxLen = Math.max(maxLen,i+1);
            }
            if(map.containsKey(a2[i])){
                maxLen = Math.max(maxLen,i-map.get(a2[i]));
            }else map.put(a2[i],i);
        }
        return maxLen;
    }
}