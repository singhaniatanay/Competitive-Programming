import java.util.*;

public class D17_Container_With_Most_Water {
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] height= new int[n];
        for(int i=0;i<n;i++){
            height[i]=scn.nextInt();
        }
        System.out.print(maxArea(height));
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array of heights
    // It should return required output.

    public static int maxArea(int[] height) {
        //Write your code here
        int left=0;
        int right=height.length-1;
        int area=0;
        while(left<right){
            int temp = Math.min(height[left],height[right])*(right-left);
            area = temp>area?temp:area;
            if(height[left]<height[right]){
                left++;
                continue;
            }
            right--;
        }
        return area;
    }
}