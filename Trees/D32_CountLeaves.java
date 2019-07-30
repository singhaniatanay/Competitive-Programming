class TNode
{
    int data;
    TNode left, right;
    TNode(int item)
    {
        data = item;
        left = right = null;
    }
}
class D32_CountLeaves
{
    int countLeaves(TNode node)
    {
        // Your code
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return 1;
        }

        return countLeaves(node.left)+countLeaves(node.right);
    }
}
