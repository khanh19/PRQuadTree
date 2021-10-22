
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * class that test the method in skipList
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 */
public class SkipListTest extends student.TestCase {
    private SkipList test;

    private KVPair rec;
    private KVPair rec1;
    private KVPair rec2;
    private KVPair rec3;
    private Point obRec2;

    /**
     * method to set up the test methods
     * runs before every test method
     */
    public void setUp() {
        test = new SkipList();
        Point obRec = new Point("cuong", 11, 10);
        Point obRec1 = new Point("khanh", 10, 5);
        obRec2 = new Point("john", 9, 10);
        Point obRec3 = new Point("cuong", 8, 5);
        rec = new KVPair(obRec.getName(), obRec);
        rec1 = new KVPair(obRec1.getName(), obRec1);
        rec2 = new KVPair(obRec2.getName(), obRec2);
        rec3 = new KVPair(obRec3.getName(), obRec3);
    }


    /**
     * method to test the size() method in KVPair;
     */
    public void testSize() {
        test.insert(rec);
        test.insert(rec1);
        assertEquals(2, test.getSize());
    }


    /**
     * method to test the remove() method in KVPair;
     */
    public void testRemove() {
        test.insert(rec);
        test.insert(rec1);
        test.insert(rec2);
        test.insert(rec3);
        assertEquals(obRec2, test.remove("john"));
        assertNull(test.remove("Khanh"));
        assertEquals(3, test.getSize());
        assertNull(test.remove("Cuong"));
        assertEquals("(10, 5)", test.remove(rec1.getValue())
            .toString());
        // assertNul(test.remove(rec1.getValue()));
        assertEquals(2, test.getSize());
        assertEquals("(11, 10)", test.remove(rec.getValue())
            .toString());
    }


    /**
     * method to test the search() method in KVPair;
     */
    public void testSearch() {
        test.insert(rec);
        test.insert(rec1);
        test.insert(rec2);
        test.insert(rec3);
        assertNotNull(test.search("cuong"));
        assertEquals("[(8, 5), (11, 10)]", test
            .search("cuong").toString());
        assertNull(test.search("Long"));
        assertEquals("[(8, 5), (11, 10)]", test
            .search("cuong").toString());
        assertEquals(2, test.search("cuong").size());
        test.dump();
    }

}
