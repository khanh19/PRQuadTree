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
    private Rectangle obRec2;

    /**
     * method to set up the test methods
     * runs before every test method
     */
    public void setUp() {
        test = new SkipList();
        Rectangle obRec = new Rectangle("cuong", 11, 10, 4, 5);
        Rectangle obRec1 = new Rectangle("khanh", 10, 5, 8, 9);
        obRec2 = new Rectangle("john", 9, 10, 4, 5);
        Rectangle obRec3 = new Rectangle("cuong", 8, 5, 6, 7);
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
        assertEquals("(khanh, 10, 5, 8, 9)", test.remove(rec1.getValue())
            .toString());
        // assertNul(test.remove(rec1.getValue()));
        assertEquals(2, test.getSize());
        assertEquals("(cuong, 11, 10, 4, 5)", test.remove(rec.getValue())
            .toString());
    }


    /**
     * method to check region search
     */
    public void testRegionSearch() {
        test.insert(rec);
        test.insert(rec1);
        test.insert(rec2);
        test.insert(rec3);
        assertEquals("[(cuong, 8, 5, 6, 7), (cuong, 11, 10, 4, 5), "
            + "(john, 9, 10, 4, 5), (khanh, 10, 5, 8, 9)]", test.regionSearch(9,
                10, 4, 5).toString());
        assertEquals("[(cuong, 8, 5, 6, 7), (cuong, 11, 10, 4, 5), "
            + "(john, 9, 10, 4, 5), (khanh, 10, 5, 8, 9)]", test.regionSearch(8,
                5, 6, 7).toString());
        assertEquals("[(cuong, 8, 5, 6, 7), (cuong, 11, 10, 4, 5), "
            + "(john, 9, 10, 4, 5), (khanh, 10, 5, 8, 9)]", test.regionSearch(
                11, 10, 4, 5).toString());
    }


    /**
     * method to test Intersection
     */
    public void testIntersection() {
        test.insert(rec);
        test.insert(rec1);
        test.insert(rec2);
        test.insert(rec3);
        test.intersection();
        assertEquals("(cuong, 8, 5, 6, 7 | cuong, 11, 10, 4, 5)\r\n"
            + "(cuong, 8, 5, 6, 7 | john, 9, 10, 4, 5)\r\n"
            + "(cuong, 8, 5, 6, 7 | khanh, 10, 5, 8, 9)\r\n"
            + "(cuong, 11, 10, 4, 5 | cuong, 8, 5, 6, 7)\r\n"
            + "(cuong, 11, 10, 4, 5 | john, 9, 10, 4, 5)\r\n"
            + "(cuong, 11, 10, 4, 5 | khanh, 10, 5, 8, 9)\r\n"
            + "(john, 9, 10, 4, 5 | cuong, 8, 5, 6, 7)\r\n"
            + "(john, 9, 10, 4, 5 | cuong, 11, 10, 4, 5)\r\n"
            + "(john, 9, 10, 4, 5 | khanh, 10, 5, 8, 9)\r\n"
            + "(khanh, 10, 5, 8, 9 | cuong, 8, 5, 6, 7)\r\n"
            + "(khanh, 10, 5, 8, 9 | cuong, 11, 10, 4, 5)\r\n"
            + "(khanh, 10, 5, 8, 9 | john, 9, 10, 4, 5)\r\n" + "", systemOut()
                .getHistory());
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
        assertEquals("[(cuong, 8, 5, 6, 7), (cuong, 11, 10, 4, 5)]", test
            .search("cuong").toString());
        assertNull(test.search("Long"));
        assertEquals("[(cuong, 8, 5, 6, 7), (cuong, 11, 10, 4, 5)]", test
            .search("cuong").toString());
        assertEquals(2, test.search("cuong").size());
        test.dump();
    }

}
