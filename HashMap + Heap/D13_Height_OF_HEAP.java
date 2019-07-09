import java.util.*;
import java.lang.*;
import java.io.*;


class D13_Height_OF_HEAP
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int x=solve(n);
        System.out.println(x);
    }


    private static int solve(int N) {
        //Write your code here
        int x=0;
        while((1<<x)<=N){
            x++;
        }
        return x-1;
    }
}