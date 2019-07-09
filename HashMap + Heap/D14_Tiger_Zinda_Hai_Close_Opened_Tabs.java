import java.util.*;

public class D14_Tiger_Zinda_Hai_Close_Opened_Tabs {

    public static int open_closeTabs(String[] T) {
        //Write your code here
        HashSet<String> set = new HashSet<>();
        for(String i:T){
            if(i.equals("END")){
                set.clear();
                continue;
            }
            if(set.contains(i)){
                set.remove(i);
                continue;
            }else{
                set.add(i);
            }

        }
        return set.size();
    }

    //Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] T = new String[n];
        for (int i = 0; i < n; i++) {
            T[i] = sc.next();
        }
        System.out.println(open_closeTabs(T));
    }

}