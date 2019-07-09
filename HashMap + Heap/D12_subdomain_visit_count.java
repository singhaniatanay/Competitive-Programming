
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class D12_subdomain_visit_count {

    private static List<String> subdomainVisits(String[] cpdomains) {
        //Write your code here
        HashMap<String,Integer> map  = new HashMap<>();
        for (int i = 0; i < cpdomains.length ; i++) {
            String curr = cpdomains[i];
            Integer count = Integer.parseInt(curr.split(" ")[0]);
            String[] allsub = curr.split(" ")[1].split(".");
            String total="";
            for (int j = 0; j <allsub.length ; j++) {
                total = allsub[i]+(j==0?"":".")+total;
                map.put(total,map.getOrDefault(total,0)+count);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key:map.keySet()) {
            ans.add(map.get(key)+" "+key);
        }
        return ans;
    }

    //Don't make any changes here
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] cpd = new String[n];
        for (int i = 0; i < cpd.length; i++) {
            cpd[i] = s.nextLine();
        }
        List<String> ans = subdomainVisits(cpd);
        Collections.sort(ans);
        System.out.println(ans);
    }

}