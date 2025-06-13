package lists;

public class LinkedList implements List {
    private int size = 0;
    private Node head = null;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null)
            head = newNode;
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int i, int index) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0 && head != null)
            head = head.next;
        else throw new IndexOutOfBoundsException();

        size--;
    }

    @Override
    public int get(int index) {
        Node current = head;
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        return current.value;
    }


}
