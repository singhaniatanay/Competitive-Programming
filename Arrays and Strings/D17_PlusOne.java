import java.util.Scanner;

public class D17_PlusOne {
    public static int[] plusOne(int[] digits) {
        //Write your code here
        int[] ans=  new int[digits.length+1];
        int carry=0;
        digits[digits.length-1]+=1;
        for(int i=digits.length-1;i>=0;i--){
            ans[i+1] = (digits[i]+carry)%10;
            carry =  (digits[i]+carry)/10;
        }
        ans[0] = carry;
        if(ans[0]==0){
            for(int i=0;i<digits.length;i++){
                digits[i] = ans[i+1];
            }
            return digits;
        }
        return ans;
    }

    //Don't make any changes here.
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] Input=new int[n];
        for(int i=0;i<Input.length;i++){
            Input[i]=scn.nextInt();
        }
        int ans[] = plusOne(Input);
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }

}