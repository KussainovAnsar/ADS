package Week2;
import java.util.Arrays;
import java.util.Iterator;

public abstract class MyArrayList<T> implements MyList<T> {

    private static final int capacity = 10;

    private Object[] arrayElements;
    private int size;
    
    public MyArrayList() {
        this.arrayElements = new Object[capacity];
        this.size = 0;
    }   // Constructor that initializes the arrayElements

    @Override
    public int size() {
        return size;
    } // Returns the number of elements in the ArrayList

    
    // Returns true if the list contains the specific element
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
    public void add(T item) {   // Adds a specified item to the end of the list
        if (size == arrayElements.length) {    // If the array is full, increase its size
            Object[] newElements = new Object[2 * arrayElements.length];
             for (int i = 0; i < arrayElements.length; i++) {
                newElements[i] = arrayElements[i];
            }
            arrayElements = newElements;
        }
        arrayElements[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {      // method adds the specified item to the list at the specified index.
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arrayElements.length) {
            Object[] newElements = new Object[2 * arrayElements.length];
            for (int i = 0; i < index; i++) 
            {
                newElements[i] = arrayElements[i];
            }
            for (int i = size-1; i >= index; i--)
            {
                newElements[i+1] = arrayElements[i];
            }
            arrayElements = newElements;
        } else {
            for (int i = size-1; i >= index; i--) 
            {
                arrayElements[i+1] = arrayElements[i];
            }
        }
        arrayElements[index] = item;
        size++;
    }

    @Override
    public boolean remove(T item) {       // method removes the specified item from the arrayList.
        for (int i = 0; i < size; i++) {
            if (arrayElements[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {               // method removes the item at the specified index from the ArrayList.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removed = (T) arrayElements[index];
        for (int i = index; i < size - 1; i++) {
        arrayElements[i] = arrayElements[i + 1];
        }
        size--;
        arrayElements[size] = null; // to avoid memory leaks
        return removed;
    }

    @Override
    public void clear() {                    // method removes all elements from the list.
        arrayElements = new Object[capacity];
        size = 0;
    }

    @Override
    public T get(int index) {               // method returns the item at the specified index.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arrayElements[index];
    }
     
    // method returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.
    // it iterates through the list and compares each element to the specified object using the equals() method.
    @Override
    public int indexOf(Object o) {       
        for (int i = 0; i < size; i++) {
            if (arrayElements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    
    // method returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.
    // it iterates through the list backwards and compares each element to the specified object using the equals() method.
    
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayElements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    
    // method sorts the elements in the list in ascending order using the Arrays.sort() method. It only sorts the elements up to the current size of the list.
    
    @Override
    public void sort() {
        Arrays.sort(arrayElements, 0, size);
    }
    
     public void sort() {
        Arrays.sort(arrayElements, 0, size);
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            return get(cursor++);
        }
    }
}
