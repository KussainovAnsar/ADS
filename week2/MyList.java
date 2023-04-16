package Week2;
import java.util.Scanner;
public interface MyList<T> {

    int size();

    boolean contains(Object o);

    void add(T item);

    void add(T item, int index);

    boolean remove(T item);

    T remove(int index);

    void clear();

    T get(int index);

    int index0f(Object o);

    int lastIndex0f(Object o);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    void sort();
}