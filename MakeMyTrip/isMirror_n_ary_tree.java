import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
		    
		    int V = sc.nextInt();
		    NTree ntree1 = new NTree(V);
		    NTree ntree2 = new NTree(V);
		    int e = sc.nextInt();
		    for(int i = 0; i < e; i++){
		        ntree1.addEdge(sc.nextInt(),sc.nextInt());
		    }
		    for(int i = 0; i < e; i++){
		        ntree2.addEdge(sc.nextInt(),sc.nextInt());
		    }

		    boolean isMirror = true;
		    for(int j = 0; j < V&&isMirror; j++){
		            int n1Size = ntree1.adj.get(j).size();
		            int n2Size = ntree2.adj.get(j).size();
		            if(n1Size==n2Size){
		                for(int i = 0; i< n1Size && isMirror; i++ ){
		                    int n1 = ntree1.adj.get(j).get(i); 
		                    int n2 = ntree2.adj.get(j).get(n1Size-i-1);
		                    if(n1!=n2){
		                        isMirror = false;
		                    }
		                }
		            }else{
		               isMirror = false;
		          }
		    }
		    if(isMirror){
		        System.out.println(1);
		    }else{
		        System.out.println(0);
		    }
		    t--;
		}
	}
	
	static class NTree {
	    
	    int V ;
	    ArrayList<LinkedList<Integer>> adj;
	    
	    NTree(int V){
	        this.V = V;
	        adj = new ArrayList<>();
	        for(int i = 0 ; i < V; i++){
	            adj.add(new LinkedList<>());            
	        }
	    }
	    
	    public void addEdge(int u, int v){
	        adj.get(u-1).add(v-1);
	    }
	    
	    
	}
	
}