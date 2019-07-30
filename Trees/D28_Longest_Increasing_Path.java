import java.util.ArrayList;

public class D28_Longest_Increasing_Path {
    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left= left;
            this.right  = right;
        }

    }
    static ArrayList<Integer> psf = new ArrayList<>();
    static ArrayList<Integer> best= new ArrayList<>();
    static void longestIncreasingPath(Node node){
        if(psf.size()>best.size()){
            best = new ArrayList<>(psf);

        }
        if(node==null)
            return;

        if(psf.size()==0 || node.data>psf.get(psf.size()-1)){
            psf.add(node.data);
            longestIncreasingPath(node.left);
            longestIncreasingPath(node.right);
            psf.remove(psf.size()-1);
        }else{
            ArrayList<Integer> temp = psf;
            psf = new ArrayList<>();
            psf.add(node.data);
            longestIncreasingPath(node.left);
            longestIncreasingPath(node.right);
            psf = temp;
        }
    }
    public static void main(String[] args) {
            //todo main from portal
    }

}
