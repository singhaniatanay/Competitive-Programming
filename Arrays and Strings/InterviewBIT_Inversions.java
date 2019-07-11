import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InterviewBIT_Inversions {
    public static int countInversions(ArrayList<Integer> A){
        int ans=0;
        int dp[] = new int[A.size()];
        for (int i = dp.length-1; i>=0 ; i--) {
            int j = i+1;
            int count=0;
            while (j<dp.length){
                if(A.get(i)>A.get(j))
                    count+=dp[j];
            }
            dp[i] = count;
        }
        return ans;
    }
    public static int countNextSmaller(ArrayList<Integer> list,int index){
        int count=0;
        for (int i = index+1; i < list.size(); i++) {
            if(list.get(i)<list.get(index)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(countInversions(list));
    }
}
