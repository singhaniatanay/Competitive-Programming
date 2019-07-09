import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Scanner;

public class D16_Ransom_Note {
    public static boolean canConstruct(String rans, String magazin) {
        //Write your code here
        HashMap<Character,Integer> ransomMap = new HashMap<>();
        HashMap<Character,Integer> magazineMap = new HashMap<>();
        char[] ransom = rans.toCharArray();
        char[] magazine = magazin.toCharArray();
        for(char i:ransom){
            ransomMap.put(i,ransomMap.getOrDefault(i,0)+1);
        }
        for(char i:magazine){
            magazineMap.put(i,magazineMap.getOrDefault(i,0)+1);
        }
        for(char i:ransomMap.keySet()){
            int rF = ransomMap.get(i);
            int mF = magazineMap.getOrDefault(i,-1);
            if(mF<rF){
                return false;
            }
        }
        return true;
    }
    //Don't make any changes here
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String t = scn.next();
        System.out.print(canConstruct(s, t));

    }

}