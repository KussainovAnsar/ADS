package Week2;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }

    private static void testArrayList() {
        MyArrayList<Integer> myList = new MyArrayList<>() {
            @Override
            public int index0f(Object o) {
                return 0;
            }

            @Override
            public int lastIndex0f(Object o) {
                return 0;
            }
        };

        // test add() method
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println(myList); // expected output: [1, 2, 3]

        // test add(int index) method
        myList.add(0, 0);
        myList.add(4, 4);
        System.out.println(myList); // expected output: [0, 1, 2, 3, 4]

        // test remove(int index) method
        myList.remove(0);
        myList.remove(3);
        System.out.println(myList); // expected output: [1, 2, 3]

        // test remove(Object o) method
        myList.remove(Integer.valueOf(2));
        System.out.println(myList); // expected output: [1, 3]

        // test get(int index) method
        System.out.println(myList.get(0)); // expected output: 1

        // test indexOf(Object o) method
        System.out.println(myList.indexOf(2)); // expected output: 1

        // test lastIndexOf(Object o) method
        myList.add(2);
        System.out.println(myList.lastIndexOf(2)); // expected output: 2

        // test contains(Object o) method
        System.out.println(myList.contains(2)); // expected output: true

        // test clear() method
        myList.clear();
        System.out.println(myList); // expected output: []
    }

    private static void testLinkedList() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        // test add(T element) method
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println(myList); // expected output: [1, 2, 3]

        // test add(T element, int index) method
        myList.add(0, 0);
        myList.add(4, 4);
        System.out.println(myList); // expected output: [0, 1, 2, 3, 4]

        // test remove(int index) method
        myList.remove(0);
        myList.remove(3);
        System.out.println(myList); // expected output: [1, 2, 3]

        // test remove(Object o) method
        myList.remove(Integer.valueOf(2));
        System.out.println(myList); // expected output: [1, 3]

        // test get(int index) method
        System.out.println(myList.get(0)); // expected output: 1



        // test indexOf(Object o) method
        System.out.println(myList.indexOf(2)); // expected output: 1

        // test lastIndexOf(Object o) method
        myList.add(2);
        System.out.println(myList.lastIndexOf(2)); // expected output: 2

        // test contains(Object o) method
        System.out.println(myList.contains(2)); // expected output:
        // test clear() method
        myList.clear();
        System.out.println(myList); // expected output: []
    }
}