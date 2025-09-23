package ss10_dsa_list_set.bai_tap.bai_tap2;

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

    // Thêm vào cuối
    public void addLast(E e) {
        Node<E> newNode = new Node<>(this.last, e, null);
        if (this.last == null) { // danh sách rỗng
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
        this.size++;
    }

    // Thêm vào đầu
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(null, e, this.first);
        if (this.first == null) { // danh sách rỗng
            this.last = newNode;
        } else {
            this.first.prev = newNode;
        }
        this.first = newNode;
        this.size++;
    }

    // Thêm vào giữa (sau index)
    public void add(int index, E e) {
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException();
        if (index == this.size) { // thêm cuối
            addLast(e);
            return;
        }
        if (index == 0) { // thêm đầu
            addFirst(e);
            return;
        }

        Node<E> curr = node(index);
        Node<E> prev = curr.prev;
        Node<E> newNode = new Node<>(prev, e, curr);

        prev.next = newNode;
        curr.prev = newNode;
        size++;
    }

    // Lấy node theo index
    private Node<E> node(int index) {
        if (index < (size / 2)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) x = x.prev;
            return x;
        }
    }

    // In ra danh sách
    public void printList() {
        Node<E> x = first;
        while (x != null) {
            System.out.print("[" + x.item + "]");
            if (x.next != null) System.out.print(" <-> ");
            x = x.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
