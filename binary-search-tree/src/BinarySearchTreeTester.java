package assignment4;

public class BinarySearchTreeTester {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(17, "Kairat");
        tree.put(20, "Aibol");
        tree.put(31, "Bekzat");
        tree.put(18, "Ademi");
        tree.put(13, "Ayzhan");
        System.out.println("The size of tree: " + tree.getSize());
        tree.delete(20);
        System.out.println("After deleting key 20, size of the tree is: " + tree.getSize());
    }
}
