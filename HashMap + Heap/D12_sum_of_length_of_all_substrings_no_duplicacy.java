import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class D12_sum_of_length_of_all_substrings_no_duplicacy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(sumOfLengthOfAllSubstringsNoDuplicates(s));
    }

    public static int sumOfLengthOfAllSubstringsNoDuplicates(String s){
        int i=0;
        int j=0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
       while (i<s.length()){
            //acquire
           while (j<s.length()&&isValid(set,s.charAt(j))){
               set.add(s.charAt(j));
               j++;
           }
           count+= set.size()*(set.size()+1)/2;
           set.remove(s.charAt(i));
           i++;

        }
       return count;
    }
    public static boolean isValid(HashSet<Character> set, char k){
        return !set.contains(k);

    }


}
