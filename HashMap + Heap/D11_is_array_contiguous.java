import java.util.*;
import java.io.*;

public class D11_is_array_contiguous {

    private static boolean isContiguous(int[] arr) {
        //Write your Code here
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr){
            set.add(i);

        }
        ArrayList<Integer> setSorted = new ArrayList<>(set);
        Collections.sort(setSorted);
        int i=setSorted.get(0);
        for(int j=1;j<setSorted.size();j++){
            if(setSorted.get(j)==i+1){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }

    //Don't make changes here
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        boolean bl = isContiguous(num);
        System.out.println(bl);
    }
}