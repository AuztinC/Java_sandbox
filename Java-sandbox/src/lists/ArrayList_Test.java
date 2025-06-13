package lists;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArrayList_Test {

    private ArrayList list;

    @Before
    public void setup() {
        list = new ArrayList();
    }

    @Test
    public void emptyListNoElements() {
        assertEquals(0, list.size());
    }

    @Test
    public void hasSizeOneAfterAdd() {
        list.add(10);
        assertEquals(1, list.size());
    }

    @Test
    public void throwsWhenIndexTooHigh() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(0));
    }

    @Test
    public void throwsWhenIndexTooLow() throws Exception {
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(-1));
    }

    @Test
    public void retrievesAddedElement() {
        list.add(10);
        assertEquals(10, list.get(0));
    }

    @Test
    public void retrievesCorrectElementAfterMultipleAdds() {
        list.add(5);
        list.add(15);
        list.add(25);
        assertEquals(5, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(25, list.get(2));
    }

    @Test
    public void removeDecreasesSize() throws Exception {
        list.add(1);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void removeShiftsElementsLeft() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(3, list.get(1));
    }

    @Test
    public void handlesMultipleAddsBeyondInitialCapacity() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        assertEquals(0, list.get(0));
        assertEquals(99, list.get(99));
    }

    @Test
    public void handlesMultipleAddsBeyondInitialCapacityWithIndex() {
        for (int i = 0; i < 100; i++) {
            list.add(i, i);
        }
        assertEquals(100, list.size());
        assertEquals(0, list.get(0));
        assertEquals(99, list.get(99));
    }

    @Test
    public void addsElementToFirstLocation() throws Exception {
        list.add(1, 0);
        assertEquals(1, list.get(0));
    }

    @Test
    public void addsElementToMiddleLocation() throws Exception {
        list.add(10); // index 0
        list.add(30); // index 1
        list.add(20, 1); // insert 20 *between* 10 and 30

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(3, list.size());

    }

    @Test
    public void throwForAddOutOfBounds() throws Exception {
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.add(1, 11));
    }

    @Test
    public void addThrowsIfIndexGreaterThanSize() {
        list.add(100);
        list.add(200);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(300, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(400, 4));
    }

    @Test
    public void removeThrowsForEmpty() throws Exception {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void removeThrowsOnInvalidIndex() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    public void removeFromMiddleShiftsElementsLeft() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.remove(1);

        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
        assertEquals(40, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void retrievesLastElement() {
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(49, list.get(49));
    }

    @Test
    public void insertAtSizeAppendsToEnd() {
        list.add(10);
        list.add(20);
        list.add(30, 2); // valid: appending at size

        assertEquals(3, list.size());
        assertEquals(30, list.get(2));
    }

    @Test
    public void insertAtZeroShiftsEverything() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 0); // should be first now

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }

    @Test
    public void add1000IntegersToEnd() throws Exception {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.size());
    }

    @Test
    public void add1000IntegersToFront() throws Exception {
        for (int i = 0; i < 1000; i++) {
            list.add(i, 0);
        }
        assertEquals(1000, list.size());
    }

    @Test
    public void add1000IntegersToMiddle() throws Exception {
        for (int i = 0; i < 1000; i++) {
            list.add(i, list.size()/2);
        }
        assertEquals(1000, list.size());
    }







}
