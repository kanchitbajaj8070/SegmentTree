public class Main {
    public static void main(String[] args) {
SegmentTree tree= new SegmentTree(new int[]{3,8,7,6,-2,-8,4,9});
    tree.display();
        System.out.println(tree.query(1,5));
        tree.update(3,14);
        tree.display();
        System.out.println(tree.query(1,5));
    }

}
