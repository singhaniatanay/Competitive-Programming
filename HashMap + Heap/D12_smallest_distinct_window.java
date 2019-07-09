import java.util.*;

class D12_smallest_distinct_window {

    public static int minLength(String s) {
        //write your code here
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i <s.length() ; i++) {
            set.add(s.charAt(i));
        }
        int noOfDistinct = set.size();
        int dsf = 0; //distinct so far
        int st = 0;
        int len=Integer.MAX_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(dsf==noOfDistinct){
                //choti kro string
                while(map.get(s.charAt(st))>1){
                    map.put(s.charAt(st),map.get(s.charAt(st))-1);
                    st++;
                }
                if(i-st<len){
                    len = i-st;
                }
            }
            //acquire
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                dsf++;
                map.put(s.charAt(i),1);
            }
        }
        if(dsf==noOfDistinct){
            //choti kro string
            while(map.get(s.charAt(st))>1){
                map.put(s.charAt(st),map.get(s.charAt(st))-1);
                st++;
            }
            if(s.length()-st<len){
                len = s.length()-st;
            }
        }
        return len;
    }

    //Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(minLength(sc.next()));
    }
}