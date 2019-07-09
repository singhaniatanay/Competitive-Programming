import java.util.*;

public class D11_identify_string {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.
    public static String reorganizeString(String S) {
        //write code here
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
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
        PriorityQueue<Map.Entry<Character,Integer>> pQ = new PriorityQueue<Map.Entry<Character, Integer>>(Collections.reverseOrder(valueComparator));
        for(Map.Entry<Character,Integer> k:list){
            pQ.add(k);
        }
        String ans="";
        while (pQ.size()>1){
            Map.Entry<Character,Integer> a = pQ.remove();
            Map.Entry<Character,Integer> b = pQ.remove();
            a.setValue(a.getValue()-1);
            b.setValue(b.getValue()-1);
            ans+=a.getKey()+b.getKey()+"";
            if(a.getValue()!=0){
                pQ.add(a);
            }
            if(b.getValue()!=0){
                pQ.add(b);
            }
        }
        if(!pQ.isEmpty()){
            ans+=pQ.remove().getKey()+"";
        }
        return ans;

    }

    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(reorganizeString(s));

    }

}