import java.util.*;

public class D14_LONGEST_SUBSTRING_WITH_EQUAL_NUMBER_0s_n_1s {

    public static void print(char[] A) {
        //Writ your code here.
        int[] arr = new int[A.length];
        int i=0;
        for(char j:A){
            arr[i++] = j=='0'?-1:1;
        }
        int len = Integer.MIN_VALUE;
        int sum=0;
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        Queue<Integer> in = new LinkedList<>();
        in.add(-1);
        map.put(sum,in);
        for(int k=0;k<arr.length;k++){
            sum+=arr[k];
            Queue<Integer> indexes = map.getOrDefault(sum,new LinkedList<Integer>());
            indexes.add(k);
            map.put(sum,indexes);
            len = len>k-map.get(sum).peek()?len:k-map.get(sum).peek();

        }
        System.out.println(len);

    }
    //Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.next();
        char[] ans = str.toCharArray();
        print(ans);
    }

}