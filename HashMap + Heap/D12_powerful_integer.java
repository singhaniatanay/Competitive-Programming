import java.util.*;

public class D12_powerful_integer {

    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int x=scn.nextInt();
        int y=scn.nextInt();
        int bound=scn.nextInt();
        ArrayList<Integer> ret = new ArrayList<>();
        ret = powerfulIntegers( x, y, bound);
        for(int i=0;i<ret.size();i++){
            System.out.print(ret.get(i)+" ");
        }
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input Integer x, y and bound.
    // It should return an ArrayList of all powerfulIntegers
    public static ArrayList<Integer> powerfulIntegers(int x, int y, int bound) {
        //Write your code here
        int xx = 0;
        int yy = 0;
        HashSet<Integer> ans = new HashSet<>();
        ans.clear();
        for (int i = 0; Math.pow(x,i) < bound ; i++) {
            xx = (int)Math.pow(x,i);
            for (int j = 0; Math.pow(y,j) < bound; j++) {
                yy = (int)Math.pow(y,j);
                if(xx+yy<=bound){
                    ans.add(xx+yy);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}