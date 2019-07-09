import java.util.*;

public class D11_k_smallest_ele_in_order {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        print_k_smallest_elements_in_their_original_order(n,k,arr);
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input length of array, value of k and array of length n
    // It should print k smallest elements in their original order
    public static void print_k_smallest_elements_in_their_original_order(int n,int k, int[] arr){

        //Write your code here

        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if(k>0){
                priorityQueue.add(arr[i]);
                k--;
            }else{
                if(arr[i]<priorityQueue.peek()){
                    priorityQueue.remove();
                    priorityQueue.add(arr[i]);
                }
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            if(!priorityQueue.isEmpty()) {
                if (arr[i] < priorityQueue.peek()) {
                    //print
                    System.out.print(arr[i]+" ");
                }
                if (arr[i] == priorityQueue.peek()) {
                    System.out.print(arr[i]+" ");
                    priorityQueue.remove();
                }
            }
        }
    }

}