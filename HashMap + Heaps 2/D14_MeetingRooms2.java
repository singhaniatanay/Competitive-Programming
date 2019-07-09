import java.lang.reflect.Array;
import java.util.*;

public class D14_MeetingRooms2 {

    // This is a functional problem. You have to complete this function.
    // It takes as input a 2D array
    // It should return the min number of meeting rooms required.

    public static int minMeetingRooms(int[][] intervals) {
        // write your code here.
        HashMap<ArrayList<Integer>,Integer> map = new HashMap<>();
        for(int[] ints:intervals)
            for (int i = ints[0]; i < ints[1]; i++) {
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(i);
                interval.add(i+1);
                map.put(interval,map.getOrDefault(interval,0)+1);
            }


        int max = Integer.MIN_VALUE;
        for(Integer val:map.values()){
            if(val>max)
                max = val;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for number of meetings.
        int N = sc.nextInt();

        int[][] intervals = new int[N][2];

        int start, end;
        // Input for intervals.
        for (int i = 0; i < intervals.length; i++) {

            start = sc.nextInt();
            end = sc.nextInt();

            intervals[i][0] = start;
            intervals[i][1] = end;
        }

        int result = minMeetingRooms(intervals);

        System.out.println(result);

    }

    // Function to display a 2D array.
    public static void display(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }


    }

}