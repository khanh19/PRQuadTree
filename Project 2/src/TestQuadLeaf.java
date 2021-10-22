
public class TestQuadLeaf extends student.TestCase{
	private QuadLeaf test;
	private QuadLeaf test1;
	private QuadLeaf test2;
	private QuadNode element;
	private Point cuong;
	private Point Long;
	private Point Test;
	
	public void setUp() {
		test = new QuadLeaf();
		test1 = new QuadLeaf();
		test2 = new QuadLeaf();
		cuong = new Point("cuong", 20, 30);
		Long = new Point("Long", 50, 60);
		Test = new Point("test", 70, 80);
	}
	
	public void testBoolean() {
		assertTrue(test.isLeaf());
		assertFalse(test.isEmpty());
		test.setNodeByOrder(element, 1);
		assertNull(test.getNodeByOrder(1));
		test.add(cuong, 0, 0, 1024);
		assertEquals("[(20, 30)]", test.getValue().toString());
		assertEquals("Node at 20, 30, 40:\n"
				+ "  (cuong, 20, 30)\n", test.traversel(20, 30, 40, 0));
		test.add(Long, 0, 0, 1024);
		test.remove(Long, 0, 0, 1024);
		assertEquals("Node at 20, 30, 40:\n"
				+ "  (cuong, 20, 30)\n", test.traversel(20, 30, 40, 0));
		test.add(Test, 0, 0, 1024);
		test.remove(Test.getX(), Test.getY(), 0, 0, 1024);
		System.out.print(test.traversel(20, 30, 40, 0));
		
		Object item = null;
		test1.setValue(item);
		
	}
}
