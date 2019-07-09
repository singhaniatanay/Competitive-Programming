import java.util.*;

public class D14_tom_n_String_GenerateHashVal {

    public static int getHashValue(String line) {
        String initial = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = line.toCharArray();
        int hash = 0;
        int j=0;
        int n=1;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                j=0;
                n++;
                continue;
            }
            hash += j+initial.indexOf(chars[i]+"");
            j++;
        }
        return n*hash;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        System.out.println(getHashValue(line));

    }

}