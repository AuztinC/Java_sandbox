package lists;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LinkedList_Test {

    private LinkedList list;

    @Before
    public void setup() {
        list = new LinkedList();
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
    public void retrievesAddedElement() throws Exception {
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @Test
    public void throwsWhenIndexTooHigh() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(0));
    }

    @Test
    public void getReturnsSecondAddedElement() {
        list.add(10);
        list.add(20);
        assertEquals(20, list.get(1));
    }

    @Test
    public void getReturnsThirdAddedElement() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(30, list.get(2));
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
    public void removeHeadGivesEmpty() throws Exception {
        list.add(1);
        list.remove(0);
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(0));
    }

    @Test
    public void headValueChangesOnRemove() throws Exception {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0));
    }

    @Ignore
    @Test
    public void removeSecondElementShiftsThirdToSecond() {
        list.add(10);  // index 0
        list.add(20);  // index 1
        list.add(30);  // index 2

        list.remove(1); // remove 20

        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1)); // 30 should shift left
        assertEquals(2, list.size());
    }



//    @Test
//    public void add1000IntegersToEnd() throws Exception {
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        assertEquals(1000, list.size());
//    }
//
//    @Test
//    public void add1000IntegersToFront() throws Exception {
//        for (int i = 0; i < 1000; i++) {
//            list.add(i, 0);
//        }
//        assertEquals(1000, list.size());
//    }
//
//    @Test
//    public void add1000IntegersToMiddle() throws Exception {
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        for (int i = 0; i < 1000; i++) {
//            list.add(i, 5);
//        }
//        assertEquals(1005, list.size());
//    }
}
