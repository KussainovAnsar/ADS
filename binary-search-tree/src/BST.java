package assignment4;
import java.util.ArrayList;
import java.util.List;
public class BST <K extends Comparable<K>,V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    public void put(K key, V value) {
        Node current = new Node(key, value);
        root = put(root, current);
    }

    private Node put(Node current, Node newNode) {
        if (current == null) return newNode;
        int comparison = current.key.compareTo(newNode.key);
        if (comparison == 0) {
            current.value = newNode.value;
        } else if (comparison < 0) {
            current.left = put(current.left, newNode);
        } else {
            current.right = put(current.right, newNode);
        }
        current.size = 1 + size(current.left) + size(current.right);
        return current;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int getSize() {
        return size(root);
    }

    public V get(K key) {
        Node newNode = root;
        return get(newNode, key);
    }

    private V get(Node newNode, K key) {
        if (newNode == null) return null;
        int comparison = key.compareTo(newNode.key);
        if (comparison == 0) {
            return newNode.value;
        } else if (comparison < 0) {
            return get(newNode.left, key);
        } else {
            return get(newNode.right, key);
        }
    }

    public void delete(K key) {
        root = delete(root, key);
        ;
    }

    private Node delete(Node current, K key) {
        if (current == null) return null;
        int comparison = key.compareTo(current.key);
        if (comparison < 0) {
            current.left = delete(current.left, key);
        } else if (comparison > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                Node temp = current;
                current = min(temp.right);
                current.right = deleteMin(temp.right);
                current.left = temp.left;
            }
        }
        current.size = 1 + size(current.left) + size(current.right);
        return current;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            node.size = 1 + size(node.left) + size(node.right);
            return node;
        }
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderKeys(root, keys);
        return keys;
    }

    private void inOrderKeys(Node node, List<K> keys) {
        if (node != null) {
            inOrderKeys(node.left, keys);
            keys.add(node.key);
            inOrderKeys(node.right, keys);
        }
    }

    public Iterable<V> iteratorValues() {
        List<V> values = new ArrayList<>();
        inOrderValues(root, values);
        return values;
    }

    private void inOrderValues(Node node, List<V> values) {
        if (node != null) {
            inOrderValues(node.left, values);
            values.add(node.value);
            inOrderValues(node.right, values);
        }
    }


}
