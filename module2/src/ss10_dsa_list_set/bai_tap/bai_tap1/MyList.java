package ss10_dsa_list_set.bai_tap.bai_tap1;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) throws ListException {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new ListException(" độ dài của mảng không thể âm!");
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyList<E> clone() {
        MyList<E> newList = new MyList<>();
        newList.elements = Arrays.copyOf(this.elements, this.size);
        newList.size = size();
        return newList;
    }

    public void add(int index, E element) throws ListException {
        checkIndex(index);
        if (size == elements.length) {
            ensureCapacity();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];

        }
        elements[size - 1] = null;
        size--;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = e;
        size++;
        return true;
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void checkIndex(int index) throws ListException {
        if (index < 0) {
            throw new ListException("Index không được âm");
        }
        if (index >= size) {
            throw new ListException("Index vượt quá giới hạn (0.." + (size - 1) + ")");
        }
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        return this.indexOf(e) >= 0;
    }

}
