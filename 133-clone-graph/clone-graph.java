import java.util.HashMap;
import java.util.Map;

class Solution {
    // Map to keep track of visited nodes and their clones
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If node was already cloned, return the existing clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new clone for the current node
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Recursively clone all the neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}