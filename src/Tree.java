public class Tree<T> {
    T node;
    Tree<T> left;
    Tree<T> right;
    public Tree(T node)
    {
        this.node = node;
        this.left = null;
        this.right = null;
    }
    public Tree<T> addLeft(T node)
    {
        this.left = new Tree<>(node);
        return this;
    }
    public Tree<T> addRight(T node)
    {
        this.right = new Tree<T>(node);
        return this;
    }
}
