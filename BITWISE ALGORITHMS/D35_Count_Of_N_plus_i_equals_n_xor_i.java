import java.util.Scanner;

public class D35_Count_Of_N_plus_i_equals_n_xor_i {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=  sc.nextInt();
        System.out.println(check(n));
    }
    public static int check(int n){
        int unsetBits=0;
        int i=0;
        while(((1<<i)<=n)){
            if((n&(1<<i))==0){
               unsetBits++;
            }
            i++;
        }
        return 1<<unsetBits;
    }
}
