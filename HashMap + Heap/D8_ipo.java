import java.util.*;

public class D8_ipo {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.

    public static int findMaximizedCapital(int k, int W, int[] Profits,
                                           int[] Capital) {
        int N = Profits.length;
        Project[] arr = new Project[N];

        for(int i=0;i<N;i++){
            arr[i]=new Project(i,Profits[i],Capital[i]);
        }
        Arrays.sort(arr,new CapitalComparator());

        PriorityQueue<Project> pq = new PriorityQueue<>(new ProfitComparator());
        int i=0;
        for(i=0;i<N;i++){
            if(arr[i].cap<=W){
                pq.add(arr[i]);
            }else{
                break;
            }
        }
        while(k-- > 0&&pq.size()>0){
            Project p = pq.remove();
            W+=p.profit;
            for(;i<N;i++){
                if(arr[i].cap<=W){
                    pq.add(arr[i]);
                }else{
                    break;
                }
            }
        }
        return W;




    }

    public static class Project{
         int profit;
         int cap;
         int index;

        Project(int index,int profit,int cap){
            this.index=index;
            this.profit=profit;
            this.cap=cap;
        }
    }

    public static class CapitalComparator implements Comparator<Project>{

        @Override
        public int compare(Project o1, Project o2) {
            return o1.cap-o2.cap;
        }
    }

    public static class ProfitComparator implements Comparator<Project>{

        @Override
        public int compare(Project o1, Project o2) {
            return o2.profit-o1.profit;
        }
    }

    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int w = sc.nextInt();

        int n = sc.nextInt();
        int[] profits = new int[n];
        int[] capital = new int[n];

        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            capital[i] = sc.nextInt();
        }

        System.out.println(findMaximizedCapital(k, w, profits, capital));

    }

}