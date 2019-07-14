import java.util.Scanner;

public class D25_Highway_Bikkboard_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M  = sc.nextInt();
        int n = sc.nextInt();
        int[] dist = new int[n];
        int[] revenue = new int[n];
        for (int i = 0; i <n; i++) {
                dist[i] = sc.nextInt();
        }
        for (int i = 0; i <n; i++) {
            revenue[i] = sc.nextInt();
        }
        int cooloff = sc.nextInt();
        System.out.println(billboardProb(dist,revenue,cooloff,M));


    }
    public static int billboardProb(int[] dist, int[] revenue,int cooloff,int miles){
        int[] dp = new int[dist.length];
        int omax = Integer.MIN_VALUE;
        for (int i = 0; i <dp.length; i++) {
            int max = revenue[i];
            for (int j = 0; j < i; j++) {
                if(dist[i]-dist[j]>cooloff){
                    //laga skte hai
                    //todo aage likhna hai
                    max  = Math.max(revenue[i]+dp[j],max);

                }else{
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max;
            omax = Math.max(dp[i],omax);
        }
        return omax;
    }
}
