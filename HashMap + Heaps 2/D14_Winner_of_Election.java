import java.util.*;

public class D14_Winner_of_Election {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scn.next();
        }
        String[] res = func(str);
        System.out.print(res[0]);
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written
    // This function takes as input an array of string
    // It should return name of winning candidate

    public static String[] func(String[] arr) {

        // Write your code here
        HashMap<String,Integer> map = new HashMap<>();
        for(String i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        String[] result = new String[map.size()];
        int max=0;
        String winner="";
        String[] keys = map.keySet().toArray(new String[map.size()]);
        Arrays.sort(keys);
        for(String j:keys){
            if(map.get(j)>max){
                max = map.get(j);
                winner =j;
            }
        }
        result[0]=winner;
        return result;


    }
}