class GFG
 {
    public static char[] maxNum;
	public static void main (String[] args) throws NumberFormatException
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int test = sc.nextInt();
	 while(test-- >0){
	     int k = sc.nextInt();
	     sc.nextLine();
	     String teststr = sc.nextLine();
	     
	     char[] str = teststr.toCharArray();
	     maxNum = teststr.toCharArray();
	     maxNumber(k,str);
	     for(int i=0; i<maxNum.length ;i++){
            System.out.print(maxNum[i]);
        }
        System.out.println();
	 }
	 }
	 
	 public static void maxNumber(int k,char[] str){
	     
	     if(k==0)
	        return;
	        
	     for(int i=0; i<str.length; i++){
	         for(int j=i+1; j<str.length ; j++){
	             
	             if(str[i] < str[j]){
	                 
		            char temp = str[i];
		                 str[i] = str[j];
		                 str[j] = temp;
		                 
		             if(isGreater(str,maxNum)){
		                 for(int a=0; a<maxNum.length ;a++){
		                     maxNum[a] = str[a];
	        			}
		                 
		             }
		                    
		                    
		                maxNumber(k-1,str);
		                 temp = str[i];
		                 str[i] = str[j];
		                 str[j] = temp;
	             }
	         }
	     }
	     
	 }
	 
	 public static boolean isGreater(char[] ch1, char[] ch2){
	     
        for(int i=0; i<ch1.length ;i++){
            
            if(ch1[i] > ch2[i])
                return true;
            else if(ch1[i] < ch2[i])
                return false;
        }
        return false;
	 }
	 
}