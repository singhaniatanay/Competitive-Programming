// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way
class LRUCache
{
   Map<Integer,Integer> map ;
    int capacity ;
    
    public LRUCache(int N) {
        
        this.map = new LinkedHashMap<Integer,Integer>();
        this.capacity = N;
    }
    
    public int get(int x) {
        int key = x;
        if(!map.containsKey(key)) return -1;
        int value = map.get(key);
        if(map.size()>1) {
            map.remove(key);
            map.put(key,value);
        }
        return value;
    }
    
    public void set(int x, int y) {
        int key = x;
        int value = y;
        if(!map.containsKey(key)) {
            if(map.size()==capacity) {
                int firstKey = map.keySet().iterator().next();
                map.remove(firstKey);
            } 
            map.put(key,value);
        } else {
            map.remove(key);
            map.put(key,value);
        }
}
}
