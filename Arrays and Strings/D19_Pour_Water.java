import java.util.*;

public class D19_Pour_Water {

    // This is a functional problem. You have to complete this function.
    // It takes as input a heights array, v and k.
    // You have to return the resultant heights array.
    public static int[] pourWater(int[] heights, int v, int k) {
        // write your code here.
        while (v>0){
            int left = k-1>=0?heights[k-1]:Integer.MAX_VALUE;
            int right = k+1<heights.length?heights[k+1]:Integer.MAX_VALUE;
            int curr = heights[k];
            if(curr<left && curr<right){
                heights[k]++;
                v--;
                continue;
            }
            //find position
            int pos = findposition(k,heights);
            heights[pos]++;
            v--;
        }
        return heights;
    }
    public static int findposition(int k,int[] heights){
        int pos = k;
        while (pos>0){
            int left = heights[pos-1];
            int curr = heights[pos];
            if(left>curr){
                //stop
                break;
            }else{
                pos--;
                continue;
            }
        }
        while (pos<heights.length-1){
            int right = pos+1<heights.length?heights[pos+1]:Integer.MAX_VALUE;
            int curr = heights[pos];
            if(right>curr){
                break;
            }else {
                pos++;
                continue;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[] arr1 = new int[N];

        // Input for array1 elements.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int V = sc.nextInt();
        int K = sc.nextInt();

        int[] result = pourWater(arr1, V, K);
        display(result);

    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}