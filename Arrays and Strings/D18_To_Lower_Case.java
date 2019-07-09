import java.util.*;

class D18_To_Lower_Case {

    public static String toLowerCase(String str) {
        //Write your code here
        char[] arr= str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='a'&&arr[i]<='z')
                continue;
            if(arr[i]>='A'&&arr[i]<='Z')
                arr[i] = (char)(arr[i]+32);
            else
                continue;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(toLowerCase(sc.next()));
    }

}