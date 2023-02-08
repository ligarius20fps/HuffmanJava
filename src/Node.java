import java.util.HashSet;
import java.util.Set;

public class Node {
    private final Set<Integer> uniqueBytes = new HashSet<>();
    private final int weight;
    public Node(Integer firstElement, int weight)
    {
        this.uniqueBytes.add(firstElement);
        this.weight = weight;
    }

    public Node(Node node1, Node node2)
    {
        this.uniqueBytes.addAll(node1.uniqueBytes);
        this.uniqueBytes.addAll(node2.uniqueBytes);
        this.weight = node1.weight + node2.weight;
    }

    public int getWeight() {
        return weight;
    }
}
