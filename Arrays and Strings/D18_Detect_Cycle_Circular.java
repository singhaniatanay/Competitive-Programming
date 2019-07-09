import java.util.HashSet;
import java.util.Scanner;

public class D18_Detect_Cycle_Circular {
    public static boolean circularArrayLoop(int[] arr) {
        //Write your code here
        boolean leftright = arr[0]>0;
        HashSet<Integer> permanentVisited = new HashSet<>();
        int i=0;

        while (i<arr.length){
            if(permanentVisited.contains(i) || arr[i]==0){
                i++;
                continue;
            }
            leftright = arr[i]>0;
            HashSet<Integer> tempVisited = new HashSet<>();
            while (true){
                int togo = arr[i];
                int nxtIndex = (i+togo)%arr.length;
                if(nxtIndex<0)
                    nxtIndex += arr.length;
                if(permanentVisited.contains(i)){
                    if(tempVisited.contains(i)){
                        return true;
                    }else{
                        break;
                    }
                }else{
                    boolean flag = arr[nxtIndex]>0;
                    if(flag==leftright){
                        //going same dirn
                        tempVisited.add(i);
                        permanentVisited.add(i);
                        i = nxtIndex;
                        continue;
                    }else {
                        break;
                    }
                }
            }
            i++;
        }
        return false;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(circularArrayLoop(arr));
    }
}

