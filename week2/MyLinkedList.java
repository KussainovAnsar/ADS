package Week2;
import java.util.Iterator; 

public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        public char[] data;
        T element;
        Node next;
        Node prev;

        Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // implementation of add() method
    public void add(T element) {
        Node newNode = new Node(element, null, tail);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    // implementation of get(int index) method
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr.element;
    }

    @Override
    public int index0f(Object o) {
        return 0;
    }

    @Override
    public int lastIndex0f(Object o) {
        return 0;
    }

    // implementation of remove(int index) method
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        if (curr.prev == null) {
            head = curr.next;
        } else {
            curr.prev.next = curr.next;
        }
        if (curr.next == null) {
            tail = curr.prev;
        } else {
            curr.next.prev = curr.prev;
        }
        size--;
        return curr.element;
    }

    // implementation of size() method
    public int size() {
        return size;
    }


    // implementation of contains(Object o) method
    @Override
    public boolean contains(Object o) {
        Node curr = head;
        while (curr != null) {
            if (curr.element.equals(o)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // implementation of add(T item, int index) method
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(item, null, null);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node curr;
            if (index < size / 2) {
                curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
            } else {
                curr = tail;
                for (int i = size - 1; i > index; i--) {
                    curr = curr.prev;
                }
            }
            newNode.prev = curr;
            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
        }
        size++;
    }
    // implementation of remove(Object o) method
    public boolean remove(T item) {
        Node curr = head;
        while (curr != null) {
            if (curr.element.equals(item)) {
                if (curr.prev == null) {
                    head = curr.next;
                } else {
                    curr.prev.next = curr.next;
                }
                if (curr.next == null) {
                    tail = curr.prev;
                } else {
                    curr.next.prev = curr.prev;
                }
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // implementation of clear() method
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // implementation of indexOf(Object o) method
    public int indexOf(Object o) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.element.equals(o)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // implementation of lastIndexOf(Object o) method
    public int lastIndexOf(Object o) {
        Node curr = tail;
        int index = size - 1;
        while (curr != null) {
            if (curr.element.equals(o)) {
                return index;
            }
            curr = curr.prev;
            index--;
        }
        return -1;
    }

    // implementation of sort() method using merge sort algorithm
    public void sort() {
        head = mergeSort(head);
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
    }

    private Node mergeSort(Node start) {
        if (start == null || start.next == null) {
            return start;
        }
        Node mid = getMiddle(start);
        Node secondHalf = mid.next;
        mid.next = null;
        Node left = mergeSort(start);
        Node right = mergeSort(secondHalf);
        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node dummy = new Node(null, null, null);
        Node curr = dummy;
        while (left != null && right != null) {
            if (0 < ((Comparable) left.element).compareTo(right.element)) {
                curr.next = right;
                right.prev = curr;
                right = right.next;
            } else {
                curr.next = left;
                left.prev = curr;
                left = left.next;
            }
            curr = curr.next;
        }
        if (left != null) {
            curr.next = left;
            left.prev = curr;
        } else {
            curr.next = right;
            right.prev = curr;
        }
        return dummy.next;
    }

    private Node getMiddle(Node start) {
        if (start == null) {
            return null;
        }
        Node slow = start;
        Node fast = start;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next(){
            T data = (T) cursor.data;
            cursor = cursor.next;
            return data;
        }
    }

}
