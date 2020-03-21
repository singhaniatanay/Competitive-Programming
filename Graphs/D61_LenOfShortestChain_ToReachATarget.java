import java.util.*;

public class D61_LenOfShortestChain_ToReachATarget {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("poon");
        dict.add("plee");
        dict.add("same");
        dict.add("poie");
        dict.add("plie");
        dict.add("poin");
        dict.add("plea");
        System.out.println(shortestChainLen(dict,"toon","plea"));

    }
    public static int shortestChainLen(Set<String> dict,String src,String target){
        Queue<Pair> q = new LinkedList<>();
        Pair item = new Pair(src,1);
        q.add(item);
        Set<String> used = new HashSet<>();
        while (!q.isEmpty()){
            Pair curr = q.remove();
            for(String w:dict){
                if(!used.contains(w) && isAdjacent(w,curr.word)){
                    item.word = w;
                    item.len = curr.len+1;
                    q.add(item);
                    used.add(w);
                    if(w.equals(target))
                        return item.len;
                }
            }
        }
        return 0;
    }
    private static boolean isAdjacent(String word, String word1) {
        int count=0;

        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = word1.charAt(i);
            if(a!=b)
                count++;
            if(count>1)
                return false;

        }
        return true;
    }
}
class Pair{
    String word;
    int len;
    Pair(String word,int len){
        this.word = word;
        this.len = len;
    }
}
