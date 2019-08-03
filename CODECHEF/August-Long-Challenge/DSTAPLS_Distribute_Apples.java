import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class DSTAPLS_Distribute_Apples {
    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = br.nextInt();
        for (int i = 0; i <t ; i++) {
            pw.println(disApples(br.nextBigInteger(),br.nextBigInteger()));
        }
        pw.flush();
        br.close();
    }

    private static String disApples(BigInteger a, BigInteger b) {
        if(a.equals(BigInteger.ZERO) || b.equals(BigInteger.ONE)){
            return "NO";
        }
        if(a.compareTo(BigInteger.ZERO)<0){
            return "YES";
        }
        return disApples(a.subtract(b.multiply(b)),b);
    }

}
