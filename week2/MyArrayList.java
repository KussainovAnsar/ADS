package Week2;
import java.util.Arrays;

public abstract class MyArrayList<T> implements MyList<T> {

    private static final int capacity = 10;

    private Object[] arrayElements;
    private int size;

    public MyArrayList() {
        this.arrayElements = new Object[capacity];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arrayElements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item) {
        if (size == arrayElements.length) {
            Object[] newElements = new Object[2 * arrayElements.length];
            System.arraycopy(arrayElements, 0, newElements, 0, arrayElements.length);
            arrayElements = newElements;
        }
        arrayElements[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arrayElements.length) {
            Object[] newElements = new Object[2 * arrayElements.length];
            System.arraycopy(arrayElements, 0, newElements, 0, arrayElements.length);
            arrayElements = newElements;
        }
        System.arraycopy(arrayElements, index, arrayElements, index + 1, size - index);
        arrayElements[index] = item;
        size++;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (arrayElements[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removed = (T) arrayElements[index];
        System.arraycopy(arrayElements, index + 1, arrayElements, index, size - index - 1);
        size--;
        arrayElements[size] = null; // to avoid memory leaks
        return removed;
    }

    @Override
    public void clear() {
        arrayElements = new Object[capacity];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arrayElements[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arrayElements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayElements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        Arrays.sort(arrayElements, 0, size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arrayElements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}