
public class TestDatabaseHandler extends student.TestCase{
	private DatabaseHandler test;
	private Point cuong;
	private Point cuong2;
	private Point cuong3;
	
	public void setUp() {
		test = new DatabaseHandler(0, 1024, 0, 1024);
		cuong = new Point("cuong", 25, 30);
		cuong2 = new Point("cuong2", -15, -20);
		cuong3 = new Point("cuong3", 25, 30);
	}
	
	public void testInsert() {
		assertEquals("Point inserted: (cuong, 25, 30)\n",test.insert(cuong));
		assertEquals("Point rejected: (cuong2, -15, -20)\n", test.insert(cuong2));
		assertEquals("Duplicate Points:\n", test.duplicate());
		test.insert(cuong3);
		assertEquals("Duplicate Points:\n"
				+ "(25, 30)\n", test.duplicate());
		assertEquals("Point Found (cuong, 25, 30)\n", test.search("cuong"));
		assertEquals("Point Not Found: Long\n", test.search("Long"));
		assertEquals("level: 2 Value: null\n"
				+ "level: 1 Value: (cuong, 25, 30)\n"
				+ "level: 2 Value: (cuong3, 25, 30)\n"
				+ "The SkipList's Size is: 2\n"
				+ "QuadTree dump:\n"
				+ "Node at 0, 0, 1024:\n"
				+ "  (cuong3, 25, 30)\n"
				+ "  (cuong, 25, 30)\n"
				+ "QuadTree Size: 1 quadtree nodes printed\n", test.dump());
	}
	
	public void testRemove() {
		test.insert(cuong);
		test.insert(cuong2);
		test.insert(cuong3);
		
		assertEquals("Point removed: (cuong, 25, 30)\n", test.removeName("cuong"));
		assertEquals("Point not removed: Triet\n"
				+ "", test.removeName("Triet"));
		assertEquals("Point removed: (cuong3, 25, 30)\n", test.removePoint(25, 30));
		assertEquals("Point removed: (cuong3, 25, 30)\n", test.removePoint(30, 35));
		assertEquals("Point rejected: (0,-2)\n", test.removePoint(0, -2));
		assertEquals("Point not found: (0, 2)\n", test.removePoint(0, 2));
	}
}
