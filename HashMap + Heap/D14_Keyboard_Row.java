import java.util.*;


class D14_Keyboard_Row {
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        String[] words= new String[n];
        for(int i=0;i<n;i++)
            words[i]=scn.next();
        String[] res= findWords(words);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array of string.
    // It should return an array of suitable strings.

    public static String[] findWords(String[] words) {
        String qwerty = "qwertyuiop";
        String asd = "asdfghjkl";
        String zxc = "zxcvbnm";
        char[] first = qwerty.toCharArray();
        char[] second = asd.toCharArray();
        char[] third = zxc.toCharArray();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        for(char i:first)
            set1.add(i);
        for(char i:second)
            set2.add(i);
        for(char i:third)
            set3.add(i);

        String ans = "";
        for(String i:words){
            boolean flag=true;
            char[] curr = i.toLowerCase().toCharArray();
            if(set1.contains(curr[0])){
                for(char j:curr){
                    if(!set1.contains(j)){
                        flag=false;
                        break;
                    }
                }
            }
            if(set2.contains(curr[0])){
                for(char j:curr){
                    if(!set2.contains(j)){
                        flag=false;
                        break;
                    }
                }
            }
            if(set3.contains(curr[0])){
                for(char j:curr){
                    if(!set3.contains(j)){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag)
                ans+=i+" ";

        }
        String[] result = ans.split(" ");
        return result;
        //Write your code here
    }
}