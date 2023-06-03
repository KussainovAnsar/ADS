import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public Double getWeight(Vertex<V> v) {
        return adjacentVertices.get(v);
    }

    public int countOfAdjacent() {
        return adjacentVertices.size();
    }

    public void addAdjacentVertices(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public boolean containsDest(Vertex<V> v) {
        return adjacentVertices.containsKey(v);
    }

    public Iterable<V> getAdjacent() {
        List<V> vertices = new ArrayList<>(adjacentVertices.size());
        for (Vertex<V> vertex : adjacentVertices.keySet()) {
            vertices.add(vertex.data);
        }
        return vertices;
    }
}