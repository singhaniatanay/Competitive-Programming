import java.util.*;

public class D9_completing_tasks {

    public static void completeTask(int n, int m, int[] compl) {

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=1;i<=n;i++){
            set.add(i);
        }
        for (int i=0;i<compl.length;i++){
            set.remove(compl[i]);
        }
        Iterator val = set.iterator();
        ArrayList<Integer> tanya = new ArrayList<>();
        ArrayList<Integer> manya = new ArrayList<>();
        boolean flag=true;
        while (val.hasNext()){
            if(flag){
                tanya.add((int)val.next());
                flag=false;
            }else{
                manya.add((int)val.next());
                flag=true;
            }
        }
        for(int i = 0; i < tanya.size(); i++) {
            System.out.print(tanya.get(i)+" ");
        }
        System.out.println();
        for(int i = 0; i < manya.size(); i++) {
            System.out.print(manya.get(i));
        }



    }
    //Don't make changes here
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = scn.nextInt();
        }
        completeTask(n, m, num);
    }
}