import java.util.*;
import java.util.Scanner;

public class D16_Remove_Comments {
    public static ArrayList<String> removeComments(String[] source) {
        //Write your code here
        ArrayList<String> ll = new ArrayList<>();
        boolean flag = true;
        String s = "";
        for(String i:source){
            char[] chars = i.toCharArray();
            for(int j=0;j<chars.length;j++){
                if(chars[j]=='/' && j+1<chars.length &&chars[j+1]=='/'){
                    flag=true;
                    break;
                }
                if(chars[j]=='*' && j+1<chars.length &&chars[j+1]=='/'){
                    flag=true;
                    j++;
                    continue;
                }
                if(chars[j]=='/' &&j+1<chars.length &&chars[j+1]=='*'){
                    flag=false;
                    j++;
                    continue;
                }
                if(flag){
                    s+=chars[j];
                }
            }
            if(flag){
                if(s=="")
                    continue;
                ll.add(s);
                s="";
            }
        }
        return ll;
    }

    //Don't make any changes here.
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] source = new String[n];
        for (int i = 0; i < source.length; i++) {
            source[i] = scn.next();
        }

        System.out.println(removeComments(source));

    }

}