import java.util.*;

public class D8_Rat_in_jungle {

    public static int numRats(int[] answers) {

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.containsKey(answer) ? map.get(answer) + 1 : 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) <= key + 1) {
                ans += key + 1;
            } else {
                ans += (key + 1) * Math.ceil(map.get(key) * 1.0 / (key + 1));

            }
        }

        return ans;

    }

    //Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] answers = new int[sc.nextInt()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = sc.nextInt();
        }
        System.out.println(numRats(answers));
    }

}