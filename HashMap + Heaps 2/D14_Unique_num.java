import java.util.*;

public class D14_Unique_num {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int l = scn.nextInt();
        int r = scn.nextInt();
        numners(l, r);
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input two numbers as range
    // It should print required output

    public static void numners(int l, int r) {
        // Write your code here
        while (l<=r){
            if(isValid(l)) {
                System.out.print(l + " ");

            }
            l++;
        }

    }
    public static boolean isValid(int i){
        HashSet<Character> set = new HashSet<>();
        char[] a = (i+"").toCharArray();
        for(char j:a){
            if(set.contains(j)){
                return false;
            }
            set.add(j);
        }
        return true;
    }
}