import java.util.Scanner;

public class D16_One_Edit_Distance {

    // This is a functional problem. You have to complete this function.
    // It takes as input two strings s and t.
    // It should return true if the strings are one edit distance apart,
    // else should return false.
    public static boolean isOneEditDistance(String s, String t) {
        // write your code here.
        if(s.length()-t.length()>1 ||s.length()-t.length()<-1){
            return false;
        }
        if(s.length()==t.length()){
            int numOfUnEqualChar=0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)!=t.charAt(i)){
                    numOfUnEqualChar++;
                }
            }
            if(numOfUnEqualChar>1){
                return false;
            }
            return true;
        }
        int i=0;
        int j=0;
        int edits=0;
        int max = s.length()>t.length()?0:1;
        while (i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
                continue;
            }else{
                edits++;
                if(max==0){
                    i++;
                    continue;
                }else{
                    j++;
                    continue;
                }
            }

        }
        if(edits>1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        if (isOneEditDistance(s, t)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}