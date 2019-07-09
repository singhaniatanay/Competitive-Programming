
public class D19_Fibbonacci_Number {
    public static int fib(int N) {
        int multiplier[][] = {
                {1,1},
                {1,0}
        };
        int[][] ans = power(multiplier,N);
        return ans[0][1];

    }

    public static int[][] mult(int[][] mat1,int[][] mat2){
        int ans[][] = new int[mat1.length][mat1[0].length];
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                for(int k=0;k<ans[0].length;k++){
                    ans[i][j] += mat1[i][k]*mat2[k][j];
                }
            }
        }
        return ans;
    }
    public static int[][] power(int[][] mat,int n){
        if(n==1)
            return mat;

        int[][] partAns=power(mat,n/2);
        if(n%2==0)
            return mult(partAns,partAns);
        else
            return mult(mat,mult(partAns,partAns));
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

};