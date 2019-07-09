import java.util.*;


class D14_IS_ISOMORPHIC{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String A= scn.next();
        String B= scn.next();
        System.out.print(isIsomorphic(A, B));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input 2 strings.
    // It should return a boolean value.

    public static boolean isIsomorphic(String s, String t) {
        //Write your code here

        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))==t.charAt(i))
                    continue;
                else
                    return false;
            }else {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        map.clear();
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i))==s.charAt(i))
                    continue;
                else
                    return false;
            }else {
                map.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;

    }
}