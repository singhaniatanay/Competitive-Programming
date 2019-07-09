import java.util.*;

public class D14_Love_for_the_twins {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(mt(arr));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array.
    // It should return an integer value.
    public static int mt(int[] arr) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        for(int i:arr){
            if(set.contains(i)){
                count +=2;
                set.remove(i);
                continue;
            }
            set.add(i);
        }
        return count;
    }
}