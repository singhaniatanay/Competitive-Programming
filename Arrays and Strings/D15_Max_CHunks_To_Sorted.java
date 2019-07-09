import java.util.*;

public class D15_Max_CHunks_To_Sorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        System.out.println(maxChunksToSorted(a));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written
    // This function takes as input an array
    // It should return required output

    public static int maxChunksToSorted(int[] arr) {
        // Write your code here
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        //left ka max <= right min
        right[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<right[i+1]){
                right[i] = arr[i];
            }else{
                right[i] = right[i+1];
            }
        }
        left[0] = Integer.MIN_VALUE;
        for(int i=1;i<left.length;i++){
            if(arr[i-1]>left[i-1]){
                left[i] = arr[i-1];
            }else{
                left[i] = left[i-1];
            }
        }
        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            if(left[i]<=right[i]){
                count++;
            }
        }
        return count;
    }
}