import java.util.*;

public class D8_is_isogram {

    public static boolean isIsogram(String data) {

        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : data.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        System.out.println(map);
        for(char key:map.keySet()){
            if(map.get(key)>1){
                return false;
            }
        }
        return true;
    }

    //Don't make any changes here
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(isIsogram(str));

    }
}