import java.io.*;
import java.util.*;

class CompetitiveProgrammingCode
{ 
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        pw.printf(br.readLine());
        pw.flush();

        String a ="a";
        StringBuilder buffer = new StringBuilder(a);
        for (int i = 0; i <100 ; i++) {
            buffer.append(i);
        }
        a = buffer.toString();
        System.out.println(a);
    } 
} 