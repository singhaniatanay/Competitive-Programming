import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D11_sort_char_by_freq {

    public static String frequencySort(String s) {
        //Write your code here
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Character, Integer>> valueComparator = new Comparator<Map.Entry<Character,Integer>>() {

            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v1-v2;
            }
        };
        Collections.sort(list,Collections.reverseOrder(valueComparator));
        String ans = "";
        for(Map.Entry<Character,Integer> i:list){
            for (int j = 0; j < i.getValue(); j++) {
                ans +=i.getKey()+"";
            }
        }
        return ans;
    }


    //Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(frequencySort(sc.next()));
    }

}