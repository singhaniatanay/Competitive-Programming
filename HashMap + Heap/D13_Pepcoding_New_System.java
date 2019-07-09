import java.util.*;

public class D13_Pepcoding_New_System {

    // This is a functional problem. You have to complete this function.
    // It takes as input a string array.
    // It should print "Verified" if the username doesn't exists already,
    //else should print the username with a number added to the end of the username.

    private static void solve(String[] str) {
        // write your code here.
        HashMap<String,Integer> map = new HashMap<>();
        for(String i:str){
            if(map.containsKey(i)){
                System.out.println(i+map.get(i));
                map.put(i,map.get(i)+1);
            }else{
                System.out.println("Verified");
                map.put(i,1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Length of the array
        int N = sc.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        solve(arr);


    }

}