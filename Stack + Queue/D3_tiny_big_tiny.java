import java.util.Scanner;

public class D3_tiny_big_tiny {
    public static boolean find132pattern(int[] num) {

        if(num.length<3){
            return false;
        }
        int a=num[0];
        int b=num[1];
        int c=num[2];
        for(int i=1;i<num.length-2;i++){
            if(a<b && b>c && a<c){
                return true;
            }
            a=num[i+1];
            b=num[i+2];
            c=num[i+3];
        }
        return false;

    }


    //Dont make changes here
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for(int i=0;i<n;i++)A[i]=sc.nextInt();
        System.out.println(find132pattern(A));
    }
}
