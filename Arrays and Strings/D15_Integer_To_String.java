import java.util.Scanner;

public class D15_Integer_To_String {
    public static String teens[] = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    public static String got[] = {"","thousand","million","billion","trillion"};
    public static String tens[] = {"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
    public static String f1(int n,int lvl){
        if(n==0)
            return "";
        return f1(n/1000,lvl+1)+" "+f2(n%1000)+" "+ got[lvl];
    }
    public static String f2(int n){
        if(n>=100){
            return teens[n/100]+" "+"hundred"+" "+f2(n%100);
        }if(n>=20){
            return tens[n/10]+" "+f2(n%10);
        }
        else{
            return teens[n];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f1(n,0).substring(1));
    }
}

