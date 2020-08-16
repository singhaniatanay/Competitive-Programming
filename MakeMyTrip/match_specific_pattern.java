// { Driver Code Starts
import java.util.*;
public class MSP
{	
    public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-- != 0)
		{
			int n=sc.nextInt();
			ArrayList<String> s = new ArrayList<String>(n);
			for (int i=0;i<n;i++)
			    s.add(sc.next());
			String tt;
			tt=sc.next();
			GfG g=new GfG();
			ArrayList<String> res =g.findMatchedWords(s, tt);
			Collections.sort(res);
			for (int i = 0;i < res.size();i++)
			    System.out.print(res.get(i)+" ");
			System.out.println();

		}
	}
}// } Driver Code Ends


/*Complete the provided function*/

class GfG
{
/* The function returns an array of strings 
present in the dictionary which matches
the string pattern.
You are required to complete this method */
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pt)
	{
	    //add code here.
	    ArrayList<String> ans = new ArrayList<>();
	    for(String word : dict){
	        HashMap<Character,Character> map = new HashMap<>();
	        if(word.length()!=pt.length()) continue;
	        boolean flag = true;
	        for(int i=0;i<word.length();i++){
	            char c = word.charAt(i);
	            char d = pt.charAt(i);
	            if(map.containsKey(d)){
	                if(map.get(d)!=c){
	                    flag = false;
	                    break;
	                }
	            }else{
	                map.put(d,c);
	            }
	        }
	        if(flag) ans.add(word);
	    }
	    return ans;
	}
}