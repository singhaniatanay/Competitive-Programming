import java.util.*;

public class D8_Notebandi {

    public static void removeString(String str, String m, String n) {

        int i = str.indexOf(m);
        boolean[] arr = new boolean[str.length()];
        for(;i<=str.length()-m.length();i++){
            if(str.substring(i,i+m.length()).equals(m)){
                Arrays.fill(arr,i,i+m.length(),true);
            }
        }

        i = str.indexOf(n);
        for(;i<=str.length()-n.length();i++){
            if(str.substring(i,i+n.length()).equals(n)){
                Arrays.fill(arr,i,i+n.length(),true);
            }
        }
        String ans="";
        for(int j=0;j<arr.length;j++){
            if(!arr[j]){
                ans = ans+str.charAt(j);
            }
        }
        System.out.println(ans);


    }


    //Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String m = sc.next();
        String n = sc.next();
        removeString(str, m, n);
    }

}