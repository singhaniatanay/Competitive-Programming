import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D8_find_duplicate_in_system {
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input the head of the linked list.
    // It should return the head of the modified list.

    private static ArrayList<ArrayList<String>> findDuplicate(String[] paths) {

        // write your code here
        LinkedHashMap<String,ArrayList<String>> map = new LinkedHashMap<>();
        for(String path:paths){
            String[] vals = path.split(" ");
            for(int i=1;i<vals.length;i++){
                String[] name_content = vals[i].split("\\(");
                name_content[1] = name_content[1].replace(")","");
                ArrayList<String> ll = map.getOrDefault(name_content[1],new ArrayList<>());
                ll.add(vals[0]+"/"+name_content[0]);
                map.put(name_content[1],ll);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> keySorted = new ArrayList<>(map.keySet());
        Collections.sort(keySorted);
        for (String val : keySorted) {
            result.add(map.get(val));
        }
        return result;

    }


    // -----------------------------------------------------

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] paths = new String[n];

        for (int i = 0; i < n; i++) {
            paths[i] = br.readLine();
        }
        ArrayList<ArrayList<String>> ans = findDuplicate(paths);
        for (ArrayList<String> val : ans) {
            Collections.sort(val);
        }

        for (ArrayList<String> val : ans) {
            System.out.println(val);
        }
    }
}