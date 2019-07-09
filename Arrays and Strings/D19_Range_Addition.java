import java.util.*;

public class D19_Range_Addition {

    // This is a functional problem. You have to complete this function.
    // It takes as input a length and a 2D array of update operations.
    // It should return the modified array.
    public static int[] getModifiedArray(int length, int[][] updates) {
        // write your code here.
        int[] arr = new int[length];
        int[] update = new int[length];
        for(int i=0;i<updates.length;i++){
            int[] currUpdate = updates[i];
            update[currUpdate[0]] += currUpdate[2];
            if(currUpdate[1]+1>=length)
                continue;
            update[currUpdate[1]+1]+= 0-currUpdate[2];
        }
        int prefixsum=0;
        for(int i=0;i<arr.length;i++){
            prefixsum+=update[i];
            arr[i] = prefixsum;
        }
        return arr;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int length = sc.nextInt();

        int K = sc.nextInt();

        int[][] updates = new int[K][3];

        for (int i = 0; i < updates.length; i++) {
            for (int j = 0; j < updates[0].length; j++) {
                updates[i][j] = sc.nextInt();
            }
        }

        int[] result = getModifiedArray(length, updates);
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