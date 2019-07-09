import java.util.*;

public class D14_Word_Pattern {

    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        String pattern= scn.nextLine();
        String str= scn.nextLine();

        System.out.println(wordPattern(pattern,str));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input 2 strings
    // It should return a boolean value

    static Boolean wordPattern(String pattern, String str) {
        //Write your code here
        char[] arr = pattern.toCharArray();
        String[] strs = str.split(" ");
        int i=0;
        HashMap<Character,String> map = new HashMap<>();
        for(char a:arr){
            if(map.containsKey(a)){
                if(!map.get(a).equals(strs[i])){
                    return false;
                }
            }else {
                map.put(a,strs[i]);
            }
            i++;
        }
        i=0;
        HashMap<String,Character> map2 = new HashMap<>();
        for(String a:strs){
            if(map2.containsKey(a)){
                if(map2.get(a)!=(arr[i])){
                    return false;
                }
            }else {
                map2.put(a,arr[i]);
            }
            i++;
        }
        return true;
    }

}