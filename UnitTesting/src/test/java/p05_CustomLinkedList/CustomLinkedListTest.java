package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> list;
    private int previousSize;

    @Before
    public void prepare() {
        list = new CustomLinkedList<>();
        list.add("Nikolai");
        list.add("Matei");
        list.add("Ognyan");
        previousSize = list.getCount();
    }

    @Test
    public void testShouldAdd() {
        list.add("Ivana");
        int currentSize = list.getCount();
        assertEquals(previousSize + 1, currentSize);
        assertEquals(list.get(currentSize - 1), "Ivana");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWhenInNegativeIndex() {
        list.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWhenIndexIBiggerThanSize() {
        list.get(list.getCount());
    }

    @Test
    public void testGetShouldGet() {
        String name = list.get(0);
        assertEquals("Nikolai", name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWhenInNegativeIndex() {
        list.set(-2, "Nikolai");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWhenIndexIBiggerThanSize() {
        list.set(list.getCount() + 1, "Nikolai");
    }

    @Test
    public void testSetShouldSet() {
        String name = "Ivana";
        list.set(list.getCount() - 1, name);
        assertEquals("Ivana", list.get(list.getCount() - 1));
    }

    @Test
    public void testIndexOfShouldFind() {
        assertEquals(0, list.indexOf("Nikolai"));
    }

    @Test
    public void testIndexOfShouldNotFind() {
        assertEquals(-1, list.indexOf("Ivana"));
    }

    @Test
    public void testContainsShouldReturnTrue() {
        assertTrue(list.contains("Nikolai"));
    }

    @Test
    public void testContainsShouldReturnFalse() {
        assertFalse(list.contains("Ivana"));
    }

    @Test
    public void testRemoveWithMissingElement() {
        assertEquals(-1, list.remove("Ivana"));
    }

    @Test
    public void testRemoveShouldRemove() {
        assertEquals(0, list.remove("Nikolai"));
        int currentSize = list.getCount();
        assertEquals(-1, list.indexOf("Nikolai"));
        assertEquals(previousSize - 1, currentSize);
    }

    @Test
    public void testRemoveAtIndexShouldRemove() {
        assertEquals("Nikolai", list.removeAt(0));
        int currentSize = list.getCount();
        assertEquals(-1, list.indexOf("Nikolai"));
        assertEquals(previousSize - 1, currentSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtIndexShouldThrowWhenIndexIsInvalid() {
        list.removeAt(15);
    }
}
