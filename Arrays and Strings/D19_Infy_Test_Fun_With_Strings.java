import java.util.ArrayList;
import java.util.HashMap;

public class D19_Infy_Test_Fun_With_Strings {
    public int func(HashMap<Character,ArrayList<Character>> map, int k,char st){
        if(k==0)
            return 1;

        ArrayList<Character> list = map.get(st);
        int ans=0;
        for(Character i:list){
            ans += func(map,k-1,i);
        }
        return ans;
    }



    public static void main(String[] args) {
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        list.add('e');
        map.put('a',list);
        ArrayList<Character> l2 = new ArrayList<>();
        l2.add('a');
        l2.add('i');
        map.put('e',l2);
        ArrayList<Character> l3 = new ArrayList<>();
        l3.add('a');
        l3.add('e');
        l3.add('o');
        l3.add('u');
        map.put('i',l3);
        ArrayList<Character> l4 = new ArrayList<>();
        l4.add('i');
        l4.add('u');
        map.put('o',l4) ;
        ArrayList<Character> l5 = new ArrayList<>();
        l5.add('a');
        map.put('u',l5);


    }
}
