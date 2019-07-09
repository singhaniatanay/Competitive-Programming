import java.util.*;

public class D13_Uncommon_Characters {
    public static void uncommon(String str1, String str2) {
        //Write your code here
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i=0;i<str1.length();i++)
            set.add(str1.charAt(i));
        for (int i=0;i<str2.length();i++)
            set2.add(str2.charAt(i));

        for (char i:set2){
            if(set.contains(i)){
                set.remove(i);
                continue;
            }
            set.add(i);
        }
        List<Character> ll = new ArrayList<>(set);
        Collections.sort(ll);
        for(Character c :ll){
            System.out.print(c+"");
        }
    }

    //Don't make any changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();

        String str2 = sc.next();

        uncommon(str1, str2);

    }
}