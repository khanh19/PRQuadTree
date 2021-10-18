// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * class that test the method in rectangle1
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 */
public class RectangleTest extends student.TestCase {
    private Rectangle test;
    private Rectangle test1;
    private Rectangle test2;
    private Rectangle test3;
    private Object test4;

    /**
     * method to set up the test methods
     * runs before every test method
     */
    public void setUp() {
        test = new Rectangle();
        test1 = new Rectangle("John", 5, 3, 2, 1);
        test2 = new Rectangle("Cuong", 3, 2, 1, 5);
        test3 = new Rectangle("Khanh", 5, 3, 2, 1);
        test4 = new Object();
    }


    /**
     * method to test the get() method in KVPair;
     */
    public void testGet() {
        test1.setName("Cuong");
        assertEquals("Cuong", test1.getName());
        assertEquals("", test.getName());
        assertEquals(0, test.getX());
        assertEquals(0, test.getY());
        assertEquals(0, test.getHeight());
        assertEquals(0, test.getWidth());
        assertEquals(3, test2.getX());
        assertEquals(2, test2.getY());
        assertEquals(1, test2.getWidth());

    }


    /**
     * method to test the set() method in KVPair;
     */
    public void testSet() {
        test.setName("Khanh");
        test.setX(10);
        test.setY(20);
        test.setHeight(30);
        assertTrue(test.setWidth(50));
        assertFalse(test.setWidth(-10));
        assertTrue(test.setHeight(50));
        assertFalse(test.setHeight(-50));
    }


    /**
     * method to test the compare() method in KVPair;
     */
    public void testCompareTo() {
        assertEquals(4, test1.compareTo(test));
        assertEquals(-4, test.compareTo(test1));
        Exception thrown = null;
        try {
            test.compareTo(null);
        }
        catch (Exception exception)

        {
            thrown = exception;
        }

        // assert that an exception was thrown

        assertNotNull(thrown);
    }


    /**
     * method to test rectangle's detail
     */
    public void testToString() {
        assertEquals("(John, 5, 3, 2, 1)", test1.toString());
    }


    /**
     * test equals method
     */
    public void testEquals() {
        assertFalse(test.equals(null));
        assertFalse(test.equals(test4));
        assertTrue(test1.equals(test3));
    }

}
