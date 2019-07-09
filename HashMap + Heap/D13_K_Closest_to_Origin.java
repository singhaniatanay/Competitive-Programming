import java.util.*;

class D13_K_Closest_to_Origin {

    // -----------------------------------------------------
    // This is a functional problem. Do not change main
    // This function takes as input a 2d array and k value
    // It should return required output as 2d array
    public static class point{
        public int i;
        public int j;
        point(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public static class PointComparator implements Comparator<point>{
        public int compare(point one,point two){
            double a = Math.sqrt(Math.pow(one.i,2)+Math.pow(one.j,2));
            double b = Math.sqrt(Math.pow(two.i,2)+Math.pow(two.j,2));
            if(a-b>0){
                return 1;
            }
            return -1;
        }
    }
    public static int[][] kClosest(int[][] points, int K) {
        //Write your code here
        PriorityQueue<point> pointPriorityQueue = new PriorityQueue<>(new PointComparator());
        for(int[] row:points){
            pointPriorityQueue.add(new point(row[0],row[1]));
        }
        int[][] p = new int[K][2];
        int i=0;
        while (K>0){
            point curr = pointPriorityQueue.remove();
            p[i][0] = curr.i;
            p[i][1] = curr.j;
            i++;
            K--;
        }
        return p;

    }
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int row=scn.nextInt();
        int[][] points= new int[row][2];
        for(int i=0;i<row;i++){
            for(int j=0;j<2;j++){
                points[i][j]=scn.nextInt();
            }
        }
        int k= scn.nextInt();
        int[][] res=kClosest(points,k);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<2;j++)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }
    }
}