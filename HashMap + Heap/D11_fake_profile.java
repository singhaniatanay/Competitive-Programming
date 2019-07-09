import java.util.*;
import java.io.*;

public class D11_fake_profile {

    public static void findIfFake(String s) {
        //Write your code here
        HashSet<Character> set = new HashSet<>();
        String vowels = "aeiou";
        for (int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i)+"")){
                continue;
            }
            set.add(s.charAt(i));
        }
        if(set.size()%2==0){
            System.out.println("SHE!");
            return;
        }
        System.out.println("HE!");
    }

    //Don't make any changes here
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        findIfFake(br.readLine());
    }
}