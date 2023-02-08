public class Tree {
    Node node;
    Tree left;
    Tree right;
    public Tree(Node node)
    {
        this.node = node;
        this.left = null;
        this.right = null;
    }
    public Tree(Node node, Tree left, Tree right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }
}
