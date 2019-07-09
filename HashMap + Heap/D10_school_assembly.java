import java.util.LinkedHashMap;
import java.util.Scanner;

public class D10_school_assembly {

    public static void minTransfer(int[] heights) {

        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<heights.length;i++){
            map.put(heights[i],0);
        }
        int max = 0;
        for(int key:map.keySet()){
            map.put(key,map.getOrDefault(key-1,0)+1);
            max = Math.max(max,map.get(key));
        }
        System.out.println(heights.length-max);

    }

    //Dont make changes here
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }
        minTransfer(heights);
    }

}