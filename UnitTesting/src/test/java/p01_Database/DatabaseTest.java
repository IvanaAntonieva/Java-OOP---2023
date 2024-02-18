package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database database;
    private final static Integer[] ARRAY = {1, 2, 8, 14};

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(ARRAY);
    }

    @Test
    public void testConstructorCreatesValidDataBase() {
        Assert.assertArrayEquals(ARRAY, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenCreateEmptyDataBase() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        database = new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenCreateBiggerThan16DataBase() throws OperationNotSupportedException {
        Integer[] bigArr = new Integer[16 + 1];
        database = new Database(bigArr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowWhenAddNullToDataBase() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElementToDataBase() throws OperationNotSupportedException {
        database.add(24);
        Integer[] elements = database.getElements();
        assertEquals(elements[elements.length - 1], Integer.valueOf(24));
        assertEquals(elements.length, ARRAY.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWhenRemoveFromEmptyDataBase() throws OperationNotSupportedException {
        for (int i = 0; i < ARRAY.length ; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveFromDataBase() throws OperationNotSupportedException {
        Integer[] elementsBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();
        assertEquals(elementsBeforeRemove.length - 1, elementsAfterRemove.length);
        assertEquals(elementsBeforeRemove[elementsBeforeRemove.length - 2], elementsAfterRemove[elementsAfterRemove.length - 1]);
    }
}
