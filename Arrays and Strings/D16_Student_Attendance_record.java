
import java.util.*;

public class D16_Student_Attendance_record {

    // This is a functional problem. You have to complete this function.
    // It takes as input a String S. It should return true if the student could
    // be rewarded, else should return false.
    public static boolean checkRecord(String s) {
        // write your code here.

        int countOfAbsent=0;
        int countOfLate=0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='A'){
                countOfAbsent++;
                continue;
            }
            if(arr[i]=='L' && i+1<arr.length && arr[i+1]=='L'){
                countOfLate++;
            }
        }
        if(countOfAbsent>1){
            return false;
        }
        if(countOfLate>1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        if (checkRecord(S)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}