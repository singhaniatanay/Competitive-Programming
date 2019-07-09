import java.util.*;

class D14_INTERSECTION_OF_TWO_ARRAYS_V2{

    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums1= new int[n];
        for(int i=0;i<n;i++){
            nums1[i]=scn.nextInt();
        }
        int m= scn.nextInt();
        int[] nums2= new int[m];
        for(int i=0;i<m;i++){
            nums2[i]=scn.nextInt();
        }
        int[] res=intersect(nums1, nums2);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input 2 arrays and m, n as lengths.
    // It should return required output.
    public static int[] intersect(int[] arr1, int[] arr2) {
        //Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        ArrayList<Integer> intersected = new ArrayList<>();
        for(int i:arr1)
            map.put(i,map.getOrDefault(i,0)+1);

        for(int i:arr2){
            if(map.containsKey(i) && map.get(i)>0){
                intersected.add(i);
                map.put(i,map.get(i)-1);
            }
        }

        Integer[] ans = intersected.toArray(new Integer[intersected.size()]);
        int[] result  =new int[ans.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans[i];
        }
        return result;
    }
}