public class SegmentTree {
/*
normal array -range sum-> O(n)
            update-O(1)
cumulative sum array - range sum->O(1)
                     update-O(n)
* segment tree- range query -> O(logn)
*           update-O(logn)
*   segment tree is a full binary tree-> every node except leaves has 2 childs
*   N leaf nodes , N-1 internal nodes
*   TotaL-> 2N-1 ( N+N-1)nodes
*
*           */
private class Node
{
    int data;
    int startInterval;
    int endInterval;
    Node left;
    Node right;
}
private Node root;
public SegmentTree(int[]arr)
{
    root=construct( arr,0,arr.length-1);
}

    private Node construct(int[] arr, int s, int e) {
if(s==e)
{
    Node leaf=new Node();
    leaf.data=arr[s];
    leaf.startInterval=s;
    leaf.endInterval=e;
    return leaf;
}
    Node nn= new Node();
    nn.startInterval=s;
    nn.endInterval=e;
    int m=(s+e)/2;
nn.left= construct(arr,s,m);
nn.right=construct(arr,m+1,e);
nn.data=nn.left.data+nn.right.data;
return nn;
}
public void display()
{
    display(root);
}

    private void display(Node root) {
if(root==null)
    return;
        System.out.println(root.data+" -> ["+root.startInterval+" , "+root.endInterval +"]");
        display(root.left);
        display(root.right);
}
}
