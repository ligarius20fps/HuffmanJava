import java.util.HashSet;
import java.util.Set;

public class Node {
    private final int weight;
    public Node(Integer firstElement, int weight)
    {
        Set<Integer> set = new HashSet<>();
        set.add(firstElement);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
