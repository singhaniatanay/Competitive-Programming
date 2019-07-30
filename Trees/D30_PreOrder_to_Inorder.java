import java.util.ArrayDeque;

public class D30_PreOrder_to_Inorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void display(TreeNode node) {
        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.val;
        str += " <= " + node.val + " => ";
        str += node.right == null ? "." : node.right.val;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static Integer[] inputSplitSpace(String str) {
        String[] sArr = str.split(" ");
        Integer[] arr = new Integer[sArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
        }
        return arr;
    }
    public static TreeNode createTree(Integer[] arr) {
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        que.addLast(root);
        int i = 1;
        while (!que.isEmpty() && i < arr.length) {
            TreeNode nn = que.removeFirst();

            if (i < arr.length && arr[i] != null) {
                TreeNode n = new TreeNode(arr[i]);
                nn.left = n;
                que.addLast(n);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                TreeNode n = new TreeNode(arr[i]);
                nn.right = n;
                que.addLast(n);
            }
            i++;
        }

        return root;
    }
    public static TreeNode construct(char[] pre,int psi,int pei,
                                     char[] in, int isi,int iei){

        if(isi>iei || psi>pei){
            return null;
        }
        int index = -1;
        for(int i=isi;i<=iei;i++){
            if(in[i]==pre[psi]){
                index = i;
                break;
            }
        }
        int lhs = index-isi;
        TreeNode node = new TreeNode(pre[psi]);
        node.left = construct(pre,psi+1,psi+lhs,in,isi,index-1);
        node.right= construct(pre,psi+lhs+1,pei,in,index+1,iei);

        return node;
    }
}
