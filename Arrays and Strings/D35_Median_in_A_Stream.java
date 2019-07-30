import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D35_Median_in_A_Stream {
    public static void main(String[] args) throws IOException {


        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            int a=scn.nextInt();
            if(min.size()==max.size()){
                max.add(a);
                min.add(max.remove());
                System.out.println(min.peek());
            }
            else{
                min.add(a);
                max.add(min.remove());
                System.out.println((min.peek()+max.peek())/2);
            }

        }
    }

}
