import java.util.*;


class D14_kth_Distinct_Element
{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        System.out.print(findKthDistinct(arr,n,scn.nextInt()));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array and n length of array.
    // It should return a boolean value.
    public static int findKthDistinct(int arr[] , int n,int k)
    {
        //Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:arr){
            if(map.get(i)==1){
                k--;
                if(k==0){
                    return i;
                }
            }
        }
        return -1;
    }
}