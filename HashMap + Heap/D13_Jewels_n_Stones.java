import java.util.*;


class D13_Jewels_n_Stones{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String J= scn.next();
        String S= scn.next();
        System.out.print(numJewelsInStones(J, S));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input 2 strings.
    // It should return an integer value.
    public static int numJewelsInStones(String J, String S) {
        //Write your code here
        HashSet<Character> set = new HashSet<>();
        char[] jj = J.toCharArray();
        char[] ss = S.toCharArray();
        for(char i:jj){
            set.add(i);
        }
        int ans=0;
        for(char i:ss){
            ans+= set.contains(i)?1:0;
        }
        return ans;
    }
}