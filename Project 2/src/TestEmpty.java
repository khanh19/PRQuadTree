import java.util.LinkedList;

public class TestEmpty extends student.TestCase{
	private QuadEmpty test;
	private QuadEmpty test2;
	private QuadEmpty test3;
	private LinkedList<String> result;
	
	private Point Test;
	private Point Test2;
	private Point Test3;
	private Point test4;
	
	
	public void setUp() {
		result = new LinkedList<String>();
		test = new QuadEmpty();
		test2 = new QuadEmpty();
		test3 = new QuadEmpty();
		Test = new Point("cuong", 1, 20);
		Test2 = new Point("Khanh", 10, 30);
		Test3 = new Point("Long", 1, 20);
		test4 = new Point("test", 200, 200);
	}
	
	public void testTraversel() {
		test.add(Test, 0, 0, 1024);
		test.add(Test2, 0, 0, 1024);
		test.add(Test3, 0, 0, 1024);
		test.add(test4, 0, 0, 1024);
		assertEquals("  Node at 0, 0, 512: Empty\n", test.traversel(0, 0, 1024, 0));
		System.out.print(test.traversel(0, 0, 1024, 0));
		assertEquals("", test.duplicate());
	}
	
	public void testRemove() {
		assertNull(test.remove(Test, 0, 0, 0));
		assertNull(test.remove(0, 0, 0, 0, 0));
		test.setValue(result);
		
		assertNull(test.getValue());
		assertFalse(test.isLeaf());
		assertNull(test.getNodeByOrder(0));
		QuadNode node = null;
		test.setNodeByOrder(node, 0);
		assertEquals("[]",test.find(0, 0, 0, 0, 0, result).toString());
		
		System.out.print(test.find(0, 0, 0, 0, 0, result).toString());
	}

}
