/*
You are given a pointer/reference to the node which
is to be deleted from the linked list of N nodes.
The task is to delete the node.
Pointer/ reference to head node is not given.

Note: No head reference is given to you.
*/


class Node{
    int data;
    Node next;
}


public class D35_GDG_SamsungProb_DeleteNode {
    void deleteNode(Node node)
    {
        // Your code here
        Node temp = node;
        Node prev = null;
        while(temp.next!=null){
            temp.data = temp.next.data;
            prev = temp;
            temp = temp.next;
        }
        if(prev==null)
            prev.next = null;
    }
}
