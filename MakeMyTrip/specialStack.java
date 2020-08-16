// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}// } Driver Code Ends

/*Complete the function(s) below*/
class GfG{
    public int minVal = Integer.MAX_VALUE;
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    minVal = Math.min(minVal,a);
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            int top = s.pop();
            if(top==minVal){
                Stack<Integer> s2 = new Stack<>();
                minVal = Integer.MAX_VALUE;
                while(!s.isEmpty()){
                    int c = s.pop();
                    minVal = Math.min(minVal,c);
                    s2.push(c);
                }
                while(!s2.isEmpty()) s.push(s2.pop());
            }
            return top;
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           return minVal;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size()==n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.isEmpty();
	}
}