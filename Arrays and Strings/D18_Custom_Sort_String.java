
import java.util.*;

class D18_Custom_Sort_String{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String S= scn.next();
        String T=scn.next();
        System.out.print(customSortString(S, T));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input two strings
    // It should return required output.

    public static String customSortString(String S, String T) {
        //Write your code here
        HashMap<Integer,String> map = new HashMap<>();
        char[] arr = T.toCharArray();
        for(char i:arr){
            int index = S.indexOf(i);
            if(index==-1){
                index = Integer.MAX_VALUE;
            }
            map.put(index,map.getOrDefault(index,"")+i);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        String ans="";
        for(Integer i:list){
            String ii = map.get(i);
            char[] chars = ii.toCharArray();
            Arrays.sort(chars);
            ans += new String(chars);
        }
        return ans;
    }
}