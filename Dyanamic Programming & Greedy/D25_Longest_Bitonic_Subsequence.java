import java.util.*;
import java.io.*;


public class D25_Longest_Bitonic_Subsequence {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int[] arr = new int[n];
		for (int i=0;i<n ;i++ ) {
			arr[i] = Integer.parseInt(inputs[i+1]);
		}
		System.out.println(LongestBitonicSubSequence(arr));

	}
	public static int LongestBitonicSubSequence(int[] arr){
		int[] lis = LIS(arr);
		int[] lds = LDS(arr);
		int ans = Integer.MIN_VALUE;
		for (int i=0;i<arr.length ; i++) {
			ans = Math.max(ans,lis[i]+lds[i]-1);
		}
		return ans;
	}
	public static int[] LIS(int[] arr){
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i=0;i<dp.length;i++) {
			int count = 0;
			for (int j=0;j<i;j++){
				if(arr[i]>arr[j]){
					//jod skte hai
					count = Math.max(dp[j],count);
				}
			}
			dp[i] = count+1;			
		}
		return dp;
	}

	public static int[] LDS(int[] arr){
		int[] dp = new int[arr.length];
		dp[dp.length-1] = 1;
		for (int i=dp.length-1;i>=0;i--) {
			int count = 0;
			for (int j=dp.length-1;j>i;j--) {
				if(arr[i]>arr[j]){
					//jod skte hai
					count = Math.max(count,dp[j]);
				}				
			}
			dp[i] = count+1;
		}
		return dp;
	}
}

	











