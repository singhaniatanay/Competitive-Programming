import java.util.*;

public class D13_Uncommon_Words {
    public static String[] uncommonFromSentences(String A, String B) {
        //Write your code here
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        String[] str1 = A.split(" ");
        String[] str2 = B.split(" ");
        for (String i:str1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (String i:str2) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        HashSet<String> set = new HashSet<>();
        for (String i:map.keySet()){
            boolean a = map.get(i)==1 && set.add(i);
        }
        List<String> ll = new ArrayList<>(set);
        Collections.sort(ll);
        String[] ans = new String[ll.size()];
        int k=0;
        for(String c :ll){
            ans[k++]= c;
        }
        return ans;

    }
    //Don't make any changes here
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String A = s.nextLine();
        String B = s.nextLine();

        String ans[] = uncommonFromSentences(A, B);
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}