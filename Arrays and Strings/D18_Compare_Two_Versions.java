import java.util.*;

class D18_Compare_Two_Versions {
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String version1= scn.next();
        String version2=scn.next();
        System.out.print(compareVersion(version1, version2));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input two strings
    // It should return required output.

    public static int compareVersion(String version1, String version2) {
        //Write your code here
        //todo reattempt
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        int i=Math.max(v1.length,v2.length);
        int j=i;
        long vv1=0;
        long vv2=0;
        for(String k:v1){
            vv1+= Integer.parseInt(k)*(Math.pow(10,i--));
        }
        for(String k:v2){
            vv1-= Integer.parseInt(k)*(Math.pow(10,j--));
        }
        if(vv1>0)
            return 1;
        if(vv1  <0)
            return -1;

        return 0;
    }
}