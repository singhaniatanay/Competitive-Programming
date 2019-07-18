import java.util.*;

public class D27_Inordewr_Traversal {

    // TreeNode class for a node of a Binary Search Tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // This is a functional problem. You have to complete this function.
    // It takes as input the root node of the given tree. It should return
    // the inorder traversal arraylist.
    public static Stack<TreeNode> nxtSmallerStack = new Stack<>();
    public static ArrayList<Integer> inorderTraversal(TreeNode node) {
        // write your code here.
        //left curr right
        ArrayList<Integer> ans = new ArrayList<>();
        pushAll(node);
        while (hasNext()){
            ans.add(next());
        }
        return ans;
    }
    private static void pushAll(TreeNode n) {
        if(n==null)
            return;
        nxtSmallerStack.add(n);
        pushAll(n.left);
    }
    public static int next() {
        int returnVal = -1;
        if(hasNext()) {
            TreeNode top = nxtSmallerStack.pop();
            returnVal = top.val;
            pushAll(top.right);
        }
        return returnVal;
    }

    /**
     * @return whether we have a next smallest number
     */
    public static boolean hasNext() {
        return !nxtSmallerStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // length of array representing the tree
        int len = sc.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = levelOrder(arr);

        ArrayList<Integer> res = inorderTraversal(root);

        for(Integer i: res){
            System.out.print(i + " ");
        }

        System.out.println();

    }

    // utility function to display a binary tree
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

    // creation of tree from array by level order, -1 says there is no node
    public static TreeNode levelOrder(int[] arr) {

        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new TreeNode(arr[i]);

                if (i > 0) {
                    int pi = (i - 1) / 2;

                    if (i == 2 * pi + 1) {
                        nodes[pi].left = nodes[i];
                    } else {
                        nodes[pi].right = nodes[i];
                    }
                }
            }
        }

        TreeNode root = nodes[0];
        return root;
    }

}