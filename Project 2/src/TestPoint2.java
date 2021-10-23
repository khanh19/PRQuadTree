import java.io.BufferedReader;
import java.io.FileReader;
public class TestPoint2 extends student.TestCase{
	private Point2 cuong;
	
	public void setUp() {
		cuong = new Point2();
	}
	
	public void testMain() throws Exception {
		BufferedReader input = new BufferedReader(new FileReader("P2test2.txt"));
		String[] command = new String[1];
		command[0] = "Test.txt";
		cuong.main(command);
		assertEquals("", systemOut().getHistory());
	}

}
