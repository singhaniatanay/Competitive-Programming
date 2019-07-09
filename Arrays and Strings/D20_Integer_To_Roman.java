import java.util.HashMap;
import java.util.Scanner;

public class D20_Integer_To_Roman {
    public static String intToRoman(int num) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        int power = (int)Math.pow(10,((num+"").length()) - 1);
        String ans = "";
        while (num>0){
            int val = (num/power)*power;
            num = num%power;

            if(map.containsKey(val)){
                ans+= map.get(val);
                power /=10;
                continue;
            }
            String curr = "";
            while (val>0){
                if(map.containsKey(val)){
                    curr = map.get(val)+curr;
                    val=0;
                    continue;
                }
                curr = map.get(power)+curr;
                val -= power;
            }
            power /=10;
            ans+=curr;

        }
        return ans;
    }


    //Don't make any changes here
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println(intToRoman(num));

    }

}