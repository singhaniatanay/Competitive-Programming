import java.util.*;

class D11_smaller_on_left {

    public static int[] greatestSmaller(int[] arr) {

        TreeSet<Integer> tree = new TreeSet<>();
        int [] ans = new int[arr.length];
        int j=0;
        for(int i:arr){
            tree.add(i);
            ans[j++] = tree.lower(i)==null?-1:tree.lower(i);
        }

        return ans;
    }

    //Dont make changes here
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        for(int val : greatestSmaller(arr))System.out.print(val+" ");
    }
}