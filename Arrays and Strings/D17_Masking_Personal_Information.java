import java.util.*;

public class D17_Masking_Personal_Information {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.print(maskPII(str));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input a string
    // It should return required output.

    public static String maskPII(String S) {
        // Write your code here

        int index = S.indexOf('@');
        if(index!=-1){
            //it is email
            String ans = S.charAt(0)+"*****"+S.substring(index-1);
            ans = ans.toLowerCase();
            return ans;
        }
        //it is a phone num
        int unmarked=0;
        String ans="";

        for(int i=S.length()-1;i>=0;i--){
            //Todo Reattempt fix formatting
            char curr = S.charAt(i);
            if(curr>='0'&&curr<='9'){
                if(unmarked==4){
                    ans = "*"+ans;
                }else{
                    ans = curr+ans;
                    unmarked++;
                }
            }else{
                ans = curr+ans;
            }
        }
        return ans;
    }
}