public class ArrayDeque<T> {
    private T[] items;
    private final int DEFAULT_CAPACITY = 8;
    private final int EXPAND_BASE = 2;
    private final int CONTRACT_BASE = 2;
    private final double RATIO = 0.25;
    private int size;
    private int front;
    private int tail;

    public ArrayDeque() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        this.front = 0;
        this.tail = 0;
    }


    private int moveLeft(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return index - 1;
        }
    }

    private int moveRight(int index) {
        if (index == this.items.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

   private void expend() {
        if (size == items.length) {
            int newCapacity = items.length * EXPAND_BASE;
            resize(newCapacity);
        }
    }

    private void contract() {
        double ratio = (double) size / items.length;
        if (ratio < RATIO) {
            int newCapacity = items.length / CONTRACT_BASE;
            resize(newCapacity);
        }
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, this.front, newItems, 0, items.length - this.front);
        System.arraycopy(items, 0, newItems, capacity - this.front, this.front);
        front = 0;
        tail = items.length;
        items = newItems;
    }

    public void addFirst(T item) {
        int nextFront = moveLeft(front);
        items[nextFront] = item;
        front = nextFront;
        size++;

        expend();
    }

    public void addLast(T item) {
        int nextTail = moveRight(tail);
        items[tail] = item;
        tail = nextTail;
        size++;

        expend();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int currentFront = front;
        while (currentFront != tail) {
            System.out.print(items[currentFront] + " ");
            currentFront = moveRight(currentFront);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int nextFront = moveRight(front);
        T removed = items[front];
        items[front] = null;
        front = nextFront;
        size--;
        contract();
        return removed;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int nextTail = moveLeft(tail);
        T removed = items[nextTail];
        items[nextTail] = null;
        tail = nextTail;
        size--;
        contract();
        return removed;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            int realIndex = front + index;
            if (realIndex >= items.length) {
                realIndex = realIndex - items.length;
            }
            return items[realIndex];
        }
    }


}
