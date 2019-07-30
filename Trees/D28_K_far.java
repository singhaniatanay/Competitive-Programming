public class D28_K_far {
    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data = data;
            this.left= left;
            this.right  = right;
        }

    }
    public static int dist=0;
    public static void kdown(Node n,int k,Node blocker){
        if(n==null||n==blocker||k<0){
            return;
        }else if(k==0){
            System.out.println(n.data);
            return;
        }
        kdown(n.left,k-1,blocker);
        kdown(n.right,k-1,blocker);
    }
    public static boolean kfar(Node node,int d,int k){
        if(node==null)
            return false;
        else if(node.data==d){
            kdown(node,k,null);
            dist++;
            return true;
        }
        else if(kfar(node.left,d,k)) {
            kdown(node, k - dist, node.left);
            dist++;
            return true;

        }
        else if(kfar(node.right,d,k)) {
            kdown(node, k - dist, node.left);
            dist++;
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
      //todo main function from pep portal

    }
}
