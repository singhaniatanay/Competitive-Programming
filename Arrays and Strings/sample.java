import java.sql.Array;
import java.util.*;

class sample {

    public static void main(String[] args) {
//        String a ="a";
//        StringBuilder buffer = new StringBuilder(a);
//        for (int i = 0; i <100 ; i++) {
//             buffer.append(i);
//        }
//        a = buffer.toString();
//        System.out.println(a);
//        ArrayList<String> b = new ArrayList<>();
//        ArrayList<String> a = new ArrayList<>(b);
//        a.addAll(b);
//        Collections.sort(a);
        int[][] dp =new int[10][10];
        Arrays.fill(dp[0],1);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();

        }

    }
}