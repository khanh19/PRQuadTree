import java.io.BufferedReader;
import java.io.FileReader;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)
/**
 * class that test the method of rectangle main
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 */
public class Rectangle1Test extends student.TestCase {
    private Rectangle1 test;

    /**
     * default constructor
     */
    public void setUp() {
        test = new Rectangle1();
    }


    /**
     * test the main method
     * 
     * @throws Exception
     *             if the input file is invalid
     */

    public void testMain() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(
            "P1test1.txt"));
        String[] command = new String[1];
        command[0] = "Test.txt";
        test.main(command);
        assertEquals("Rectangle rejected: "
            + "(inExist_Rec0, 1, 1, 0, 10)\r\n"
            + "Rectangle rejected: "
            + "(inExist_Rec1, 1, 1, 7, -10)\r\n"
            + "Rectangle rejected: "
            + "(inExist_Rec2, 0, 0, 0, 0)\r\n"
            + "Rectangle rejected: "
            + "(inExist_Rec3, -1, -2, 7, 10)\r\n"
            + "Rectangle rejected: "
            + "(inExist_Rec4, -1, 1, -2, 10)\r\n"
            + "Intersections pairs:\r\n"
            + "Rectangle not removed: (inExist_Rec1)\r\n"
            + "Rectangle rejected: (12, 1, 7, -6)\r\n"
            + "Rectangle rejected: (r1, 0, 0, 217, 1474647)\r\n"
            + "Rectangle inserted: (r2, 10, 10, 15, 15)\r\n"
            + "Rectangle inserted: (R2, 11, 11, 5, 5)\r\n"
            + "Rectangle inserted: (r3, 0, 0, 1000, 10)\r\n"
            + "Rectangle inserted: (r4, 0, 0, 10, 1000)\r\n"
            + "Rectangle rejected: (900, 5, 0, 0)\r\n"
            + "Rectangles intersecting region (900, 5, 1, 1):\r\n"
            + "(r3, 0, 0, 1000, 10)\r\n"
            + "Rectangle rejected: (5, 900, 0, 1)\r\n"
            + "Rectangle rejected: (0, 0, 217, 1474647)\r\n"
            + "Rectangle found: \r\n" + "(r2, 10, 10, 15, 15)\r\n", systemOut()
                .getHistory());
    }
}
