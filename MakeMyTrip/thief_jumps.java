
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		GFG gfg = new GFG();
		Scanner sc = new Scanner(System.in);
		
		int testCases, x, y, n, count, h[], t;
		testCases = sc.nextInt();
		
		for(int i = 0; i < testCases; i++)
		{
		    x = sc.nextInt();
		    y = sc.nextInt();
		    n = sc.nextInt();
		    h = new int[n];
		    count = 0;
		    
		    for(int j = 0; j < n; j++)
		    {
		        h[j] = sc.nextInt();
		    }
		    
		    for(int j = 0; j < n; j++)
		    {
		        if(h[j] <= x)
		        {
		            count++;
		        }
		        else
		        {
		            t = h[j];
		            
		            while(t > x)
		            {
		                count++;
		                t = t - (x - y);
		            }
		            count++;
		        }
		    }
		    
		    System.out.println(count);
		}
	
	}

}