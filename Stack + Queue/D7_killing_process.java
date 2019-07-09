import java.util.*;
 
 class D7_killing_process {
 
     public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
         
         HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
         int root=-1;
         for(int i=0;i<pid.size();i++){
             int parent = ppid.get(i);
             int child = pid.get(i);
             if(parent==0){
                 root = child;
             }
             ArrayList<Integer> arr = new ArrayList<>();
             
             if(map.containsKey(parent)){
                 arr = map.get(parent);
                 arr.add(child);

                map.put(parent,arr);
             }else{
                 arr.add(child);
                map.put(parent,arr);
             }
             
         }
         List<Integer> ans = new ArrayList<>();
         Queue<Integer> q = new LinkedList<>();
         q.add(kill);
         while(q.size()!=0){
             int x = q.remove();
             ans.add(x);
             ArrayList<Integer> children = map.get(x);
             if(children!=null){
                for(int i=0;i<children.size();i++){
                     q.add(children.get(i));
                }
             }
         }
         
         return ans;
         
         
         
     }
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int k = sc.nextInt();
         List<Integer> pid = new ArrayList<>(n);
         List<Integer> ppid = new ArrayList<>(n);
         for (int i = 0; i < n; i++) {
             pid.add(sc.nextInt());
         }
         for (int i = 0; i < n; i++) {
             ppid.add(sc.nextInt());
         }
 	 List<Integer>res=killProcess(pid, ppid, k);
 	 Collections.sort(res);
         System.out.println(res);
     }
 }
