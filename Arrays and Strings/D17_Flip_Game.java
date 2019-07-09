import java.util.*;

public class D17_Flip_Game {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        List<String> res = generatePossibleNextMoves(s);
        System.out.print(res);
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input a string
    // It should return required List

    public static List<String> generatePossibleNextMoves(String s) {
        // Write your code here
        List<String> ll = new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            char curr = s.charAt(i);
            char nxt = s.charAt(i+1);
            if(curr==nxt && curr=='+'){
                //possible move
                String ans = s.substring(0,i)+"-";
                if(i+2<s.length()){
                    ans+=s.substring(i+2);
                }
                ll.add(ans);
            }
        }
        return ll;
    }
}