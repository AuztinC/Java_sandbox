package lists;

import java.util.Arrays;

public class ArrayList implements List {
    private int size = 0;
    private int[] elements = new int[10];
    private int currentElement = 0;

    private void shiftRemainingRight(int index) {
        for (int i = size - 1; i >= index; i--)
            elements[i + 1] = elements[i];
    }

    private void shiftRemainingLeft(int index) {
        for (int i = index; i < elements.length - 1; i++)
            elements[i] = elements[i + 1];
    }

    private void doubleCapacityIfFull() {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @Override
    public void add(int element) {
        doubleCapacityIfFull();
        elements[currentElement++] = element;
        size++;
    }

    @Override
    public void add(int element, int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        doubleCapacityIfFull();
        shiftRemainingRight(index);
        elements[index] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        shiftRemainingLeft(index);
        size--;
    }

    @Override
    public int get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return elements[index];
    }
}
