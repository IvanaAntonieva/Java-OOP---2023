package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database database;
    private static final Person NIKOLAI = new Person(11, "Nikolai");
    private static final Person MATEI = new Person(12, "Matei");
    private static final Person OGNYAN = new Person(13, "Ognyan");
    private static final Person[] ARRAY = {NIKOLAI, MATEI, OGNYAN};

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(NIKOLAI, MATEI, OGNYAN);
    }

    @Test
    public void testConstructorCreateValidDataBase() {
        assertArrayEquals(ARRAY, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenCreateEmptyDataBase() throws OperationNotSupportedException {
        Person[] emptyArr = new Person[0];
        database = new Database(emptyArr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenCreateBiggerThan16DataBase() throws OperationNotSupportedException {
        Person[] bigArr = new Person[16 + 1];
        database = new Database(bigArr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsWhenAddNullToDataBase() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElementToDataBase() throws OperationNotSupportedException {
        Person ivana = new Person(14, "Ivana");
        database.add(ivana);
        Person[] elements = database.getElements();
        assertEquals(elements[elements.length - 1], ivana);
        assertEquals(elements.length, ARRAY.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowsWhenRemoveFromEmptyDataBase() throws OperationNotSupportedException {
        for (int i = 0; i < ARRAY.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveFromDataBase() throws OperationNotSupportedException {
        Person[] elementsBeforeRemove = database.getElements();
        database.remove();
        Person[] elementsAfterRemove = database.getElements();
        assertEquals(elementsBeforeRemove[elementsBeforeRemove.length - 2], elementsAfterRemove[elementsAfterRemove.length-1]);
        assertEquals(elementsBeforeRemove.length, elementsAfterRemove.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenMissing() throws OperationNotSupportedException {
        database.findByUsername("Ivana");
    }

    @Test
    public void testFindByUsernameShouldReturn() throws OperationNotSupportedException {
        Person person = database.findByUsername(NIKOLAI.getUsername());
        assertEquals(NIKOLAI.getUsername(), person.getUsername());
    }

    @Test
    public void testFindByIdShouldReturn() throws OperationNotSupportedException {
        Person person = database.findById(NIKOLAI.getId());
        assertEquals(NIKOLAI.getId(), person.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWhenMissing() throws OperationNotSupportedException {
        database.findById(15);
    }
}
