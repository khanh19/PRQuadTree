
public class TestQuadInternal extends student.TestCase {
	private QuadInternal Test;
	private QuadInternal Test1;
	private QuadInternal Test2;
	private Point test;
	private Point test2;
	private Point test3;
	private Point test4;

	public void setUp() {
		Test = new QuadInternal();
		Test1 = new QuadInternal();
		Test2 = new QuadInternal();

		test = new Point("cuong", 1, 20);
		test2 = new Point("Khanh", 10, 30);
		test3 = new Point("Long", 1, 20);
		test4 = new Point("test", 200, 200);
	}

	public void testAll() {
		Object item = null;
		Test.setValue(item);
		assertFalse(Test.isLeaf());
		assertNull(Test.getValue());
		System.out.print(Test.traversel(0, 0, 1024, 4));
		assertEquals("        Node at 0, 0, 1024: Internal\n"
				+ "          Node at 0, 0, 512: Empty\n"
				+ "          Node at 512, 0, 512: Empty\n"
				+ "          Node at 0, 512, 512: Empty\n"
				+ "          Node at 512, 512, 512: Empty\n", Test.traversel(0, 0, 1024, 4));
		Test.add(test, test.getX(), test.getY(), 1024);
		Test.add(test2, test2.getX(), test2.getY(), 1024);
		Test.add(test3, test3.getX(), test3.getY(), 1024);
		Test.add(test4, test4.getX(), test4.getY(), 1024);
		Test.remove(test4.getX(), test4.getY(), 0, 0, 1024);
		Test.remove(test4, 0, 0, 1024);
		assertEquals("        Node at 0, 0, 1024: Internal\n"
				+ "          Node at 0, 0, 512:\n"
				+ "            (cuong, 1, 20)\n"
				+ "            (Khanh, 10, 30)\n"
				+ "            (Long, 1, 20)\n"
				+ "          Node at 512, 0, 512: Empty\n"
				+ "          Node at 0, 512, 512: Empty\n"
				+ "          Node at 512, 512, 512: Empty\n", Test.traversel(0, 0, 1024, 4));
		
	}
}
