import java.util.*;

public class D10_max_points_on_line {

    public static int maxPoints(Point[] points) {

        int max = 2;
        for(int i =0; i<points.length;i++){
            HashMap<String,Integer> map = new HashMap<>();
            for (int j=i+1;j<points.length;j++){
                int x1 = points[i].x;
                int y1 = points[i].y;
                int x2 = points[j].x;
                int y2 = points[j].y;

                int dx = x2-x1;
                int dy = y2-y1;

                int gcd=gcd(dx,dy);
                dy = dy/gcd;
                dx = dx/gcd;
                String key = dy+","+dx;
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                    if(map.get(key)>max){
                        max = map.get(key);
                    }
                }else {
                    map.put(key,2);
                }
            }
        }
        return max;

    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    ///Dont make changes here
    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        System.out.println(maxPoints(points));
    }
}