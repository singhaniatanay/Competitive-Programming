import  java.util.*;

public class D26_Average_Lvls_In_A_Binary_Tree {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        // Write your code here
        ArrayList<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int lvlCount = 0;
        int val=0;
        while (!q.isEmpty()){
            TreeNode curr  = q.remove();
            if(curr==null){
                if(lvlCount!=0) {
                    Double avg = ((double) val) / lvlCount;
                    ans.add(avg);
                }
                if(q.size()>0)
                    q.add(null);
                val=0;
                lvlCount=0;
                continue;
            }
            val+= curr.val;
            lvlCount++;
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        Integer[] treeArr = inputSplitSpace(input);
        TreeNode root = createTree(treeArr);
        List<Double> res = averageOfLevels(root);
        for (Double v : res) {
            System.out.print(v + " ");
        }
        System.out.println();

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