import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class InterviewBit_Min_Step_Infinite_Grid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            X.add(sc.nextInt());
        }
        for (int i = 0; i <n ; i++) {
            Y.add(sc.nextInt());
        }
        System.out.println(coverPoints(X,Y));
    }
    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int steps= 0;
        int i=0;
        while (i<A.size()-1){
            int x = A.get(i);
            int y = A.get(i);
            int x1 = A.get(i+1);
            int y1 = A.get(i+1);
            //possible slopes are Inf,0,1,-1 in which it can move
            int absYdiff = y1>y?y1-y+1:y-y1+1;
            int absXdiff = x1>x?x1-x+1:x-x1+1;
            if(x1-x==0){
                steps += absYdiff;
                i++;
                continue;
            }
            float slope = ((float)(y1-y))/(x1-x);
            if(slope==0){
                steps += absXdiff;
            }else if(slope==1){
                steps += absYdiff;
            }else if(slope==-1){
                steps += absYdiff;
            }else{
                if(slope>-1 && slope<1){
                    A.set(i,y1);
                    B.set(i,y1);
                    steps+=absYdiff;
                    continue;
                }else {
                    A.set(i,x1);
                    B.set(i,x1);
                    steps+=absXdiff;
                    continue;
                }

            }
            i++;
        }
        return steps;
    }
}
