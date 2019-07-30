import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;
    left=null;
    right=null;
    }
}
class Helper{
    TreeNode node;
    int vlvl;
    Helper(TreeNode node,int lvl){
        this.vlvl = lvl;
        this.node = node;
    }
}

public class IB_Vertical_Order_Traversal {

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        Helper root = new Helper(A,0);
        Queue<Helper> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Helper curr = q.remove();
            if(map.containsKey(curr.vlvl)){
                ArrayList<Integer> currLL = map.get(curr.vlvl);
                currLL.add(curr.node.val);
                map.put(curr.vlvl,currLL);
            }else{
                ArrayList<Integer> currLL = new ArrayList<>();
                currLL.add(curr.node.val);
                map.put(curr.vlvl,currLL);
            }

            if(curr.node.left!=null){
                Helper left = new Helper(curr.node.left,curr.vlvl-1);
                q.add(left);
            }
            if(curr.node.right!=null){
                Helper right = new Helper(curr.node.right,curr.vlvl+1);
                q.add(right);
            }

        }

        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(keys);
        for(int i:keys){
            ans.add(map.get(i));
        }
        return ans;
    }

}
