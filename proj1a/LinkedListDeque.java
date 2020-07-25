public class LinkedListDeque<T> {

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null,null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public class Node {
        private Node pre;
        private Node next;
        private T item;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.pre = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.pre = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.pre.next = sentinel.pre;
        size++;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node currentNode = sentinel.next;
        while (currentNode != sentinel) {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println();

    }

    public T removeFirst() {
        T p = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return p;
    }

    public T removeLast() {
        T p = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return p;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node currentNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    public T getRecursive(int index) {

        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);

    }

    public T getRecursiveHelp(Node currentNode, int index) {
        if (index == 0) {
            return currentNode.item;
        }
        return getRecursiveHelp(currentNode.next, index - 1);
    }
}
