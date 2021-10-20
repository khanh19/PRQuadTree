
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * class that test the method in SkipNode
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 */
public class SkipNodeTest extends student.TestCase {
    private SkipNode test;

    /**
     * method to set up the test methods
     * runs before every test method
     */
    public void setUp() {
        test = new SkipNode("cuong", 20);
    }


    /**
     * method to test the value() method in KVPair;
     */
    public void testValue() {
        assertEquals("cuong", test.value());
        assertNull(test.getElevate()[0]);
    }

}
