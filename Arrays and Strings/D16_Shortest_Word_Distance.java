
import java.util.*;
class D16_Shortest_Word_Distance {
    public static int shortestWordDistance(String[] words, String word1, String word2) {
        //Write your code here

        HashMap<String,ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i <words.length ; i++) {
            ArrayList<Integer> indexes = map.getOrDefault(words[i],new ArrayList<>());
            indexes.add(i);
            map.put(words[i],indexes);
        }
        int min = Integer.MAX_VALUE;
        for(Integer i:map.get(word1)){
            for(Integer j:map.get(word2)){
                int len=-1;
                if(i<j){
                    len = j-i;
                }
                if(i>j){
                    len = words.length-j+i-1;
                }
                if(len==-1)
                    continue;
                if(len<min){
                    min=len;
                }
            }
        }


        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        String word1 = sc.next(), word2 = sc.next();
        System.out.println(shortestWordDistance(words, word1, word2));
    }

}