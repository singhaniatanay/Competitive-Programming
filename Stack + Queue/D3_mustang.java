import java.util.Scanner;
  
  public class D3_mustang{
  
  	  public static int mustangTour(int[] petrol,int[] dist){
  	      
  	      int i=0,j=0;
  	      int spare = 0;
  	      
  	      while(i<dist.length){
  	          if(j==dist.length){
  	              j=0;
  	          }
  	          if(spare<0){
  	              if(j<i){
  	                  return -1;
  	              }
  	              i=j;
  	              spare = 0;
  	          }
  	          else{
  	              if(i==0&&j==dist.length-1){
  	                  break;
  	              }
  	              if(j+1==i){
  	                  break;
  	              }else{
  	                  spare = spare +petrol[j]-dist[j];
  	                  j++;
  	              }
  	          }
  	          
  	      }
  	      
  	      if(spare+petrol[j]-dist[j]>=0){
  	          return i;
  	      }
  	      return -1;
  	      
  	  }
  
  
  
  
  
  	  // Dont make changes here
  	  public static void main(String[] args) {
  	  	  Scanner sc=new Scanner(System.in);
  	  	  int n=sc.nextInt();
  	  	  int[] petrol=new int[n];int[] dist=new int[n];
  	  	  for(int i=0;i<n;i++)petrol[i]=sc.nextInt();
  	  	  for(int i=0;i<n;i++)dist[i]=sc.nextInt();
  	  	  System.out.println(mustangTour(petrol,dist));
  	  }
  
  
  
  }
