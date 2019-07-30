import java.util.ArrayDeque;

public class D30_MORRIS {
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

    public static void morris(TreeNode node){
        while(node!=null){
            if(node.left==null){
                System.out.println(node.val);
                node = node.right;
            }else{
                TreeNode LftKaRightMost = lkaRM(node);
                if(LftKaRightMost.right==null){
                    LftKaRightMost.right = node;
                    node = node.left;
                }
                else if(LftKaRightMost.right==node){
                    LftKaRightMost.right=null;
                    System.out.println(node.val);
                    node = node.right;
                }
            }
        }
    }

    private static TreeNode lkaRM(TreeNode node) {
        TreeNode lkarm = node.left;
        while (lkarm.right!=null && lkarm.right!=node){
            lkarm = lkarm.right;
        }
        return lkarm;
    }

}
