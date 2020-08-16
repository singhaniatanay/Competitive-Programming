// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            GfG g = new GfG();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}
// } Driver Code Ends


class GfG {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        // Your code here
      int []arr1 = new int[N];
      arr1[0] = arr[0] == 0 ? -1 : 1;
      for ( int i = 1 ; i < N; i++){
          arr1[i] = arr1[i-1]+(arr[i] == 0 ? -1 : 1);
      }
      int maxLength = 0;
      HashMap<Integer,Integer> map = new HashMap<>();
      int i = 0;
      for ( int s : arr1){
          if ( s == 0 ){
              maxLength = Math.max(maxLength,i+1);
          }
          if(map.containsKey(s)){
              maxLength = Math.max(maxLength,i-map.get(s));
          }
          else 
            map.put(s,i);
        i++;
      }
      return maxLength;
    }
}
