//Given a Binary Tree, convert it into its mirror.

class D33_MirrorTree
{
    void mirror(TNode node)
    {
        // Your code here
        if(node==null || (node.left==null&&node.right==null)){
            return;
        }
        TNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        mirror(node.left);
        mirror(node.right);

    }
}