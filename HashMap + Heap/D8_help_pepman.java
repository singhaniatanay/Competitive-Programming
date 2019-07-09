import java.util.HashMap;
import java.util.Scanner;

public class D8_help_pepman {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(pepman(str));
    }

    public static String pepman(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int even = 0;
        int odd = 0;
        for (char c : map.keySet()) {
            if((c-96)%2==0&&map.get(c)%2==0){
                even++;
                continue;
            }
            if((c-96)%2==1&&map.get(c)%2==1){
                odd++;
            }
        }
        if((odd+even)%2==0){
            return("EVEN");
        }
        else{
            return "ODD";
        }
    }
}
