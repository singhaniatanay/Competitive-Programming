import java.util.Scanner;

public class D21_Longest_Increasing_Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(LIS(arr));
        System.out.println(LongestIncreasingSequence(arr));
    }
    public static int  LIS(int[] arr){
        int OverallMax=0;
        int[] dp = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            OverallMax = Math.max(LISatAPoint(arr,i,dp),OverallMax);
        }
        return OverallMax;
    }
    public static int  LISatAPoint(int[] arr, int point,int[] dp){
        if(point==0)
            return 1;
        if(dp[point]!=0)
            return dp[point];

        int LISatthatPt =0;
        for (int i = 0; i <point ; i++) {
            if(arr[i]<arr[point]){
                //jod skte hai
                int LISatCurrPoint = LISatAPoint(arr, i, dp);
                LISatthatPt = Math.max(LISatCurrPoint,LISatthatPt);
            }
        }
        LISatthatPt++;
        dp[point] = LISatthatPt;
        return LISatthatPt;
    }
    public static int  LongestIncreasingSequence(int a[]){
        int[] arr = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            if(i==0) {
                arr[i] = 1;
                continue;
            }
            int max=0;
            for (int j = 0; j < i; j++) {
                if(a[j]<=a[i]){
                    //jod skte hai
                    max = Math.max(arr[j],max);
                }
            }
            arr[i] = max+1;
        }

        int maximum=Integer.MIN_VALUE;
        for(int x:arr){
            if(x>maximum)
                maximum=x;
        }
        return maximum;
    }
}
