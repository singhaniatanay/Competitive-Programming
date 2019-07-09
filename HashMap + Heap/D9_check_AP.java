import java.util.*;

public class D9_check_AP {

    public static boolean checkAP(int[] arr) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : arr) {
            hashSet.add(value);
        }
        Iterator i = hashSet.iterator();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (i.hasNext()){
            int next = (int)i.next();
            max = Integer.max(max,next);
            min = Integer.min(min,next);
        }

        int d = (max-min)/(arr.length-1);

        int num = min;
        for(int j=2;j<hashSet.size();j++){
            if(hashSet.contains(num+d)){
                num=num+d;
            }
            else{
                return false;
            }
        }

        return true;


    }


    //Don't make any changes here
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        boolean x = checkAP(num);
        System.out.println(x);
    }
}