import java.util.*;

public class D20_Global_And_Local_Inversions {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return true if the number
    // of global inversions are equal to the number of local inversions, else
    // should return false.
    public static boolean isIdealPermutation(int[] A) {
        // write your code here.
        int maxIndex=0;
        int maxVal=0;
        for (int i = 0; i < A.length; i++) {
            if(maxVal>A[i]){
                if(i-maxIndex>1)
                    return false;
            }else{
                maxIndex=i;
                maxVal = A[i];
            }
        }
        int minIndex=0;
        int minVal=0;
        for (int i = A.length-1; i >=0; i--) {
            if(minVal<A[i]){
                if(minIndex-i>1)
                    return false;
            }else{
                minIndex=i;
                minVal = A[i];
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        if (isIdealPermutation(arr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}