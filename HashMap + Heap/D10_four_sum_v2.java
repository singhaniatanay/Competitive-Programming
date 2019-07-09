import java.util.*;

public class D10_four_sum_v2 {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //write your code here
        HashMap<Integer,Integer> AB = new HashMap<>();
        HashMap<Integer,Integer> CD = new HashMap<>();
        int ans = 0;
        for (int i = 0; i <A.length ; i++) {
            for (int j = 0; j < A.length; j++) {
                AB.put(A[i]+B[j],AB.getOrDefault(A[i]+B[j],0)+1);
                CD.put(C[i]+D[j],CD.getOrDefault(C[i]+D[j],0)+1);
            }
        }
        for(Integer key:AB.keySet()){
            if(CD.containsKey(0-key)){
                ans+=AB.get(key)*CD.get(0-key);
            }
        }
        return ans;
    }

    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int []arr1=new int[n];
        int []arr2=new int[n];
        int []arr3=new int[n];
        int []arr4=new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr3[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr4[i] = sc.nextInt();
        }

        System.out.println(fourSumCount(arr1, arr2, arr3, arr4));

    }

}