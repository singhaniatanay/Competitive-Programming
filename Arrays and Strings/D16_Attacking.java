import java.util.*;

class D16_Attacking {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        //Write your code here
        int st=timeSeries[0];
        int end=st+duration;
        int time=0;
        for(int i=1;i<timeSeries.length;i++){
            if(timeSeries[i]<=end){
                end = timeSeries[i]+duration-1;
                continue;
            }else{
                time += end-st+1;
                st=timeSeries[i];
                end = st+duration-1;
            }
        }
        if(end!=st)
            time += end-st+1;
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] timeseries = new int[n];
        for (int i = 0; i < n; i++) {
            timeseries[i] = sc.nextInt();
        }
        System.out.println(findPoisonedDuration(timeseries, k));
    }

}