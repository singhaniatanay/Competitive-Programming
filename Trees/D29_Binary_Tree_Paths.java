import java.util.*;

public class D29_Binary_Tree_Paths {

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
    // It takes as input the root node of a binary tree. It should return
    // an arraylist containing all root-to-leaf paths in any order.
    public static ArrayList<String> binaryTreePaths(TreeNode root) {
        // write your code here.
        getBtPaths(root,"");
        return btPaths;

    }
    public static ArrayList<String> btPaths = new ArrayList<>();
    public static void getBtPaths(TreeNode root,String pathSoFar){
        if(root==null)
            return;

        if(root.left==null && root.right==null){
            //leaf
            pathSoFar+= root.val;
            btPaths.add(pathSoFar);
            return;
        }
        pathSoFar+= root.val+"->";
        getBtPaths(root.left,pathSoFar);
        getBtPaths(root.right,pathSoFar);

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        Integer[] treeArr = inputSplitSpace(input);
        TreeNode root = createTree(treeArr);

        ArrayList<String> result = binaryTreePaths(root);
        Collections.sort(result);
        for(String s: result){
            System.out.println(s);
        }

    }

    // utility function to display a binary tree.
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

    // utility function, don't change its code
    public static Integer[] inputSplitSpace(String str) {
        String[] sArr = str.split(" ");
        Integer[] arr = new Integer[sArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
        }
        return arr;
    }

    // utility function to create a tree, don't change its code.
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


}