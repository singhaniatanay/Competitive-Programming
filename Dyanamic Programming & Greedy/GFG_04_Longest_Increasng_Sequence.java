import java.util.Scanner;

public class GFG_04_Longest_Increasng_Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] answers = new int[t];
        for (int i = 0; i <t ; i++) {
            int[] arr = new int[sc.nextInt()];
            for (int j = 0; j <arr.length ; j++) {
                arr[j] = sc.nextInt();
            }
            answers[i] = LongestIncreasingSequence(arr);
        }
        for(int i:answers){
            System.out.println(i);
        }
    }


    public static int LongestIncreasingSequence(int a[]){
        int[] arr = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            if(i==0) {
                arr[i] = 1;
                continue;
            }
            int max=0;
            for (int j = 0; j < i; j++) {
                if(a[j]<a[i]){
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
