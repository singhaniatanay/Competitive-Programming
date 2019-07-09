import java.util.Scanner;

public class D17_Robot_Return_to_Origin_Judge_Circle {

    public static boolean judgeCircle(String s) {
        // Write code here
        int x=0;
        int y=0;
        char[] arr = s.toCharArray();
        for(char i:arr){
            if(i=='U'){
                y++;
            }else if(i=='L'){
                x--;
            }else if(i=='D'){
                y--;
            }else if(i=='R'){
                x++;
            }

        }
        if(x==0 && y==0){
            return true;
        }
        return false;
    }

    // Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(judgeCircle(str));

    }
}