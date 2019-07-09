import java.util.*;

public class D16_Similar_RGB_Color {

    public static String similarRGB(String color) {
        //Write your code here
        String hex = "0123456789ABCDEF";
        String ans = "#";
        for (int l = 1; l < color.length()-2; l+=2) {
            String i = color.substring(l,l+2);
            int i_msd = hex.indexOf(i.charAt(0));
            int i_Nxt_msd = hex.indexOf(i.charAt(1));
            if(i_msd>=i_Nxt_msd){
                String upperbound = hex.charAt(i_msd)+""+hex.charAt(i_msd)+"";
                String lowerbound="";
                if(i_msd-1<0){
                    lowerbound = hex.charAt(hex.length()-1)+""+hex.charAt(hex.length()-1)+"";
                }else{
                    lowerbound = hex.charAt(i_msd-1)+""+hex.charAt(i_msd-1)+"";
                }
                int hexUp = Integer.parseInt(upperbound,16);
                int hexLow = Integer.parseInt(lowerbound,16);
                int hexi = Integer.parseInt(i);
                if(hexi-hexLow>hexUp-hexi){
                    ans+=upperbound;
                }else{
                    ans+=lowerbound;
                }

            }else{
                String lowerbound = hex.charAt(i_msd)+""+hex.charAt(i_msd)+"";
                String upperbound="";
                if(i_msd+1>=hex.length()){
                    upperbound = hex.charAt(0)+""+hex.charAt(0)+"";
                }else{
                    upperbound = hex.charAt(i_msd+1)+""+hex.charAt(i_msd+1)+"";
                }
                int hexUp = Integer.parseInt(upperbound,16);
                int hexLow = Integer.parseInt(lowerbound,16);
                int hexi = Integer.parseInt(i);
                if(hexi-hexLow>hexUp-hexi){
                    ans+=upperbound;
                }else{
                    ans+=lowerbound;
                }

            }

        }


        return ans;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(similarRGB(sc.next()));
    }

}