/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class D4_Expressions
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	    Scanner s = new Scanner(System.in);
	    String exp = s.nextLine();
	    String[] arr = exp.split(" ");
	    
	    System.out.println(evalInfix(arr));
	    System.out.println(infixToPrefix(arr));
	    System.out.println(infixToPostfix(arr));
	    
	    
	    
	    
	}
	
	public static double evalInfix(String[] str){
	    
	    Stack<Double> ns = new Stack<>();
	    Stack<String> os = new Stack<>();
	    HashMap<String,Integer> map = new HashMap<>();
	    map.put("+",1);
	    map.put("-",1);
	    map.put("*",2);
	    map.put("/",2);
	    map.put("^",3);
	    
	    for(int i=0;i<str.length;i++){

	        if(str[i].equals("(")){
	            os.push(str[i]);
	            continue;
	        }
	        if(str[i].equals("+")
	            ||str[i].equals("-")
	            ||str[i].equals("*")
	            ||str[i].equals("/")
	            ||str[i].equals("^")){
	                
	                while(os.size()!=0&&!os.peek().equals("(")&&map.get(os.peek())>=map.get(str[i])){
	                    ns.push(eval(ns.pop(),ns.pop(),os.pop()));
	                    
	                }
	                os.push(str[i]);
	                continue;
	        }
	        if(str[i].equals(")")){
	            while(!os.peek().equals("(")){
	                ns.push(eval(ns.pop(),ns.pop(),os.pop()));
	            }
	            os.pop();
	            continue;
	        }else{
	            ns.push(Double.parseDouble(str[i]));
	        }
	    }
	    
	    while(!os.empty()){
	        ns.push(eval(ns.pop(),ns.pop(),os.pop()));
	    }
	    return ns.peek();
	    
	}
	
	public static double eval(double a,double b,String op){
	    if(op.equals("+")){
	        return a+b;
	    }
	    if(op.equals("-")){
	        return b-a;
	    }
	    if(op.equals("/")){
	        return b/a;
	    }
	    if(op.equals("*")){
	        return a*b;
	    }
	    if(op.equals("^")){
	        return Math.pow(b,a);
	    }
	    return 0;
	}
	
	public static String infixToPostfix(String[] str){
	    Stack<String> ns = new Stack<>();
	    Stack<String> os = new Stack<>();
	    HashMap<String,Integer> map = new HashMap<>();
	    map.put("+",1);
	    map.put("-",1);
	    map.put("*",2);
	    map.put("/",2);
	    map.put("^",3);
	    
	    for(int i=0;i<str.length;i++){

	        if(str[i].equals("(")){
	            os.push(str[i]);
	            continue;
	        }
	        if(str[i].equals("+")
	            ||str[i].equals("-")
	            ||str[i].equals("*")
	            ||str[i].equals("/")
	            ||str[i].equals("^")){
	                
	                while(os.size()!=0&&!os.peek().equals("(")&&map.get(os.peek())>=map.get(str[i])){
	                    ns.push(ns.pop()+""+ns.pop()+""+os.pop());
	                    
	                }
	                os.push(str[i]);
	                continue;
	        }
	        if(str[i].equals(")")){
	            while(!os.peek().equals("(")){
	                ns.push(ns.pop()+""+ns.pop()+""+os.pop());
	            }
	            os.pop();
	            continue;
	        }else{
	            ns.push(str[i]);
	        }
	    }
	    
	    while(!os.empty()){
	        ns.push(ns.pop()+""+ns.pop()+""+os.pop());
	    }
	    String ans ="";
	    String peek = ns.peek();
	    for(int i=peek.length()-1;i>=0;i--){
	        ans += peek.charAt(i);
	    }
	    return ans;
	    
	    
	}
	
	public static String infixToPrefix(String[] str){
	    Stack<String> ns = new Stack<>();
	    Stack<String> os = new Stack<>();
	    HashMap<String,Integer> map = new HashMap<>();
	    map.put("+",1);
	    map.put("-",1);
	    map.put("*",2);
	    map.put("/",2);
	    map.put("^",3);
	    
	    for(int i=0;i<str.length;i++){

	        if(str[i].equals("(")){
	            os.push(str[i]);
	            continue;
	        }
	        if(str[i].equals("+")
	            ||str[i].equals("-")
	            ||str[i].equals("*")
	            ||str[i].equals("/")
	            ||str[i].equals("^")){
	                
	                while(os.size()!=0&&!os.peek().equals("(")&&map.get(os.peek())>=map.get(str[i])){
	                ns.push(os.pop()+""+ns.pop()+""+ns.pop());
	                    
	                }
	                os.push(str[i]);
	                continue;
	        }
	        if(str[i].equals(")")){
	            while(!os.peek().equals("(")){
	                ns.push(os.pop()+""+ns.pop()+""+ns.pop());
	            }
	            os.pop();
	            continue;
	        }else{
	            ns.push(str[i]);
	        }
	    }
	    
	    while(!os.empty()){
	                ns.push(os.pop()+""+ns.pop()+""+ns.pop());
	    }
	    String ans ="";
	    String peek = ns.peek();
	    for(int i=peek.length()-1;i>=0;i--){
	        ans += peek.charAt(i);
	    }
	    return ans;
	}
	
	public static void evalPrefix(String[] str){
	    
	}
	
	public static void prefixToPostfix(String[] str){
	    
	}
	
	public static void prefixToInfix(String[] str){
	    
	}
	
	public static void evalPostfix(String[] str){
	    
	}
	
	public static void postfixToInfix(String[] str){
	    
	}
	
	public static void postFixToPrefix(String[] str){
	    
	}
	
}
