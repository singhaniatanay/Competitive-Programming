import java.util.*;
import javax.sound.sampled.BooleanControl.Type;

public class D15_Long_Pressed_Name {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String name = scn.next();
        String typed = scn.next();
        System.out.println(isLongPressedName(name, typed));

    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input 2 strings
    // It should return boolean output.
    public static boolean isLongPressedName(String name, String typed) {
        // Write your code here
        int i=0;
        int j=0;
        while (j<typed.length()){
            char currB = typed.charAt(j);
            char currA = '/';
            if(i<name.length()) {
                currA = name.charAt(i);
            }else{
                currA = typed.charAt(j-1);
            }
            if (currA == currB) {
                    i++;
                    j++;
                    continue;
            }else if(currB==typed.charAt(j-1)){
                j++;
                continue;
            }else{
                return false;
            }
        }
        if(i<name.length())
            return false;
        return true;
    }

}