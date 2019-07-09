import java.util.*;
 class D6_absolute_canonical_path {
     public static String absoluteCanonicalPath(String s) {
         
         Stack<String> st = new Stack<>();
         for(int i=0;i<s.length();i++){
             if(st.empty()&&s.charAt(i)=='/'){
                st.push("/");
                continue;
            }
            else if(s.charAt(i)=='/'){
                if(st.peek().equals("/")){
                   continue; 
                }else{
                    st.push("/");
                }
            }
            else if(s.charAt(i)=='.'){
                if(!st.empty()&&s.charAt(++i)=='.'){
                    st.pop();
                    if(!st.empty())
                        st.pop();
                }
            }else{
                if(!st.peek().equals("/")){
                    st.push(st.pop()+s.charAt(i));
                }else{
                    st.push(s.charAt(i)+"");
                }
            }
         
         }
         
         if(!st.empty()&&st.peek().equals("/"));
            st.pop();
            
        String ans="";
        while(!st.empty()){
            ans=st.pop()+ans;
        }
        if(ans.equals(""))
            ans="/";
         return ans;
     }
 
 
 
 
 
 
 
 
 
 
  // Dont make changes here   
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         String path=sc.next();
         System.out.print(absoluteCanonicalPath(path));
     }
 }
