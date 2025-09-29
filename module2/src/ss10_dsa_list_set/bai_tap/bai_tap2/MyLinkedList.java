package ss10_dsa_list_set.bai_tap.bai_tap2;


import ss10_dsa_list_set.bai_tap.bai_tap1.MyList;

class MyLinkedList<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public MyLinkedList() {
    }

    public boolean add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    public void addFirst(E e) {
        Node<E> newNote = new Node<>(null, e, this.first);

        if (this.first == null) {
            add(e);
        } else {
            this.first.prev = newNote;
        }
        this.first = newNote;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNote = new Node<>(this.last, e, null);
        if (this.last == null) {
            add(e);
        } else {
            this.last.next = newNote;
        }
        this.last = newNote;
        size++;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<E> succ = node(index);     // node hiện tại ở vị trí index
            Node<E> pred = succ.prev;       // node trước nó
            Node<E> newNode = new Node<>(pred, element, succ);

            succ.prev = newNode;
            pred.next = newNode;
            size++;
        }
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private Node<E> node(int index) {
        Node<E> x;
        if (index < (size / 2)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }
    public int size(){
        return this.size;
    }
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
