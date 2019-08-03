import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MSNSADM1_Football {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i <t ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            int[] B = new int[n];
            String[] a = br.readLine().split(" ");
            String[] b = br.readLine().split(" ");
            for (int j = 0; j <n ; j++) {
                A[j] = Integer.parseInt(a[j]);
                B[j] = Integer.parseInt(b[j]);
            }
            pw.println(football(A,B));
        }
        pw.flush();
        br.close();
    }

    private static int football(int[] a, int[] b) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int score = (a[i]*2)-b[i];
            score = score<0?0:score;
            max = score>max?score:max;
        }
        return max*10;
    }
}
