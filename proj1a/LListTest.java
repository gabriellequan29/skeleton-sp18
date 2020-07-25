import org.junit.Test;

public class LListTest {

    @Test
    public void addFirstTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(10);
        linkedListDeque.addFirst(15);
        linkedListDeque.printDeque();
    }

    @Test
    public void addLastTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        linkedListDeque.addLast(5);
        linkedListDeque.addLast(10);
        linkedListDeque.addLast(15);
        linkedListDeque.printDeque();
    }

    @Test
    public void isEmptyTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        System.out.println(linkedListDeque.isEmpty());
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(10);
        linkedListDeque.addFirst(15);
        System.out.println(linkedListDeque.isEmpty());
    }

    @Test
    public void sizeTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        System.out.println(linkedListDeque.size());
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(10);
        linkedListDeque.addFirst(15);
        System.out.println(linkedListDeque.size());
    }

    @Test
    public void removeFirstTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(10);
        linkedListDeque.addFirst(15);
        linkedListDeque.printDeque();
        linkedListDeque.removeFirst();
        linkedListDeque.printDeque();
    }

    @Test
    public void removeLastTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(10);
        linkedListDeque.addFirst(15);
        linkedListDeque.printDeque();
        linkedListDeque.removeLast();
        linkedListDeque.printDeque();
    }

    @Test
    public void getTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        System.out.println(linkedListDeque.get(1));
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(10);
        linkedListDeque.addFirst(15);
        System.out.println(linkedListDeque.get(1));
        System.out.println(linkedListDeque.get(3));
    }

    @Test
    public void getRecursiveTest() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<Integer>();
        System.out.println(linkedListDeque.getRecursive(1));
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(10);
        linkedListDeque.addFirst(15);
        System.out.println(linkedListDeque.getRecursive(1));
        System.out.println(linkedListDeque.getRecursive(3));
    }

}
