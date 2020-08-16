import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
public static void main (String[] args) {
    Scanner sc =new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while(t-->0){
    int a=0;
    int b=0;
    int c=0;
    int d=0;
    String n=sc.nextLine();
    
    for(int i=0;i<n.length();i++){ 
        if(n.charAt(i)>='a' && n.charAt(i)<='z')    a++;
        else if(n.charAt(i)>='A' && n.charAt(i)<='Z')    b++;
        else if(n.charAt(i)>='0' && n.charAt(i)<='9')    c++;
    
    }
    System.out.println(b);
    System.out.println(a);
    System.out.println(c);
    System.out.println(n.length()-a-b-c);
    }
    
    }
}