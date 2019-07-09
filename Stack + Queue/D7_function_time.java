import java.util.*;
 
 public class D7_function_time {
 
     public static int[] exclusiveTime(int n, List<String> logs) {
         
         int[] ans = new int[n];
         int[] arr = new int[3];
         //[process id,start time, not my time ]
         
         Stack<int[]> st = new Stack<>();
         
         for(int i=0;i<logs.size();i++){
             
             if(logs.get(i).contains("start")){
                 st.push(new int[]{Integer.parseInt(logs.get(i).charAt(0)+"")
                                    ,Integer.parseInt(logs.get(i).substring(8))
                                    ,0});
             }else{
                 int[] pop = st.pop();
                 int time = Integer.parseInt(logs.get(i).substring(6))-pop[1]+1;
                 ans[pop[0]]=time-pop[2];
                 if(st.size()!=0){
                    pop = st.pop();
                    pop[2]=pop[2]+time;
                    st.push(pop);
                 }
             }
         }
         return ans;
     }
     
     
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int L = sc.nextInt();
         List<String> logs = new ArrayList<>(L);
         for (int i = 0; i < L; i++) {
             logs.add(sc.next());
         }
         int[] res = exclusiveTime(n, logs);
         for (int i = 0; i < res.length; i++) {
             System.out.print(res[i] + " ");
         }
     }
 
 }
