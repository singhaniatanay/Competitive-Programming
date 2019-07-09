import java.util.*;

public class D14_kth_Element_In_Matrix {

    // This is a functional problem. You have to complete this function.
    // It takes as input a matrix and K.
    // It should return the Kth smallest element from the matrix.
    public static int findKthSmallest(int[][] nums, int k) {
        // write your code here.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int[] row:nums){
            for(int ele:row)
                priorityQueue.add(ele);
        }
        while (k>1){
            priorityQueue.remove();
        }
        return priorityQueue.peek();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[][] mat = new int[N][N];

        // Input for matrix elements.
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int K = sc.nextInt();

        int result = findKthSmallest(mat, K);

        System.out.println(result);

    }

    // Function to display a matrix.
    public static void display(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

}