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
public int query(int start, int end)
{/*
three cases
1. node interval lies inside start interval -> rreturn its value
2. Completely outside ( nsi > qei && nei< qsi)//q-> query and si-> start interval
return default vaue of query like 0 for sum Integer.MIN_VALUE for max query
3. Overlapping -> call left and right childs and deduce answer from these values*/

return query(root,start,end);

}

    private int query(Node node, int qsi, int qei) {
    if( node.startInterval>=qsi&&node.endInterval<=qei )
        return node.data;//completely inside Case 1
        else if( node.startInterval> qei || node. endInterval< qsi)
            return 0;//default value CASE2 .. completely ouside
        else //case 3 overlapping case
            {
        return query(node.left,qsi,qei)+query(node.right,qsi,qei);
            }

    }
    public void update(int index, int value) {
    //1. if index lies completely inside node index-> call left and right
        //2. if not lying b/w node intervals return data;
        //3. if start and end interval 0 equal . change value of node and return new value
        root.data=update(root, index,  value);
        System.out.println(root.data);
    }

    private int update(Node root, int index, int value) {
    if(root.startInterval==index&&root.endInterval==index)
    {
        root.data=value;//Case 3
        return value;
    }
    else if( root.endInterval<index||root.startInterval> index)
    {//CASE 2
        return root.data;
    }
    else
    {  // completely inside Case1
        int leftans=update(root.left,index,value);
        int rightans=update(root.right,index,value);
        root.data=leftans+rightans;
        return root.data;
    }
    }

}
