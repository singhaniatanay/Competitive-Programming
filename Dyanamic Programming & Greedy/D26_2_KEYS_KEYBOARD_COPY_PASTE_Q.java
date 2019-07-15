import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D26_2_KEYS_KEYBOARD_COPY_PASTE_Q {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        pw.printf(""+minSteps(Integer.parseInt(br.readLine())));
        pw.flush();
    }
    public static int minSteps(int num){
        int[] factors = primeFactorisation(num);
        int ans = 0;
        for (int i = 0; i < factors.length; i++) {
            ans+= i*factors[i];
        }
        return ans;
    }
    public static int[] primeFactorisation(int n){
        int[] factors = new int[n+1];
        int len = (int)Math.sqrt(n);
        for (int f = 2; f <=len; f++) {
            while (n%f==0){
                n=n/f;
                factors[f]++;
            }
        }
        if(n!=1){
            factors[n]++;
        }
        return factors;
    }
}
