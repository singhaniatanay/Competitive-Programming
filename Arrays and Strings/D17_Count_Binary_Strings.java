import java.util.*;

class D17_Count_Binary_Strings{
    public static void main(String[] args){
        Scanner scn= new Scanner (System.in);
        String s=scn.next();
        System.out.print(countBinarySubstrings(s));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input a string
    // It should return the required output

    public static int countBinarySubstrings(String s) {
        //write code here
        char[] arr = s.toCharArray();
        int prev=0;
        int curr=1;
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(prev>=curr){
                count++;
            }
            if(arr[i]==arr[i-1]){
                curr++;
            }else{
                prev=curr;
                curr=1;
            }
        }
        return count;
    }

}