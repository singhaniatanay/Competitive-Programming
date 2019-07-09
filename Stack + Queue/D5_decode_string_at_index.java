import java.util.*;
  import java.io.*;
  public class D5_decode_string_at_index {
  	   public static Character decodeIndex(String str, int k) {
  	       int size = 0;
  	       for(int i=0;i<str.length();i++){
  	           if(str.charAt(i)>96&&str.charAt(i)<123){
  	               size++;
  	               continue;
  	           }
  	           else{
  	               int a = Integer.parseInt(str.charAt(i)+"");
  	               size*=a;
  	           }
  	       }
  	       
  	       
  	       for(int i=str.length()-1;i>=0;i--){

  	           if(str.charAt(i)>96 && str.charAt(i)<123){
  	               if(k+1%size==0){
  	                   return str.charAt(i);
  	               }else{
  	                   size--;
  	               }
  	               
  	           }else{
  	               size=size/Integer.parseInt(str.charAt(i)+"");
  	           }
  	           k=k+1%size;
  	           
  	       }
  	       return 'i';
  	  }
  
  
  
  	  
  
  	  // Dont make changes here
  	  public static void main(String[] args) {
  	  	  Scanner sc=new Scanner(System.in);
  	  	  String s=sc.next();
  	  	  int k=sc.nextInt();
  	  	  System.out.println(decodeIndex(s,k));
  	  }
  
  }
