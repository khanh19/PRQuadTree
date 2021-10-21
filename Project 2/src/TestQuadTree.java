
public class TestQuadTree extends student.TestCase {
	private QuadTree tree;
	private Point test;
	private Point test2;
	private Point test3;
	private Point test4;
	private Point test5;

	public void setUp() {
		test = new Point("cuong", 1, 20);
		test2 = new Point("Khanh", 10, 30);
		test3 = new Point("Long", 1, 20);
		test4 = new Point("test", 200, 200);
		tree = new QuadTree(0, 1024, 0, 1024);
	}

	public void testInsert() {
		tree.insert(test);
		tree.insert(test2);
		tree.insert(test3);
		tree.insert(test4);
		assertEquals(4, tree.getSize());
		System.out.print(tree.dump());
		assertEquals("Node at 0, 0, 1024: Internal\n"
				+ "  Node at 0, 0, 512: Internal\n"
				+ "    Node at 0, 0, 256: Internal\n"
				+ "      Node at 0, 0, 128:\n"
				+ "        (cuong, 1, 20)\n"
				+ "        (Khanh, 10, 30)\n"
				+ "        (Long, 1, 20)\n"
				+ "      Node at 128, 0, 128: Empty\n"
				+ "      Node at 0, 128, 128: Empty\n"
				+ "      Node at 0, 0, 128:\n"
				+ "        (test, 200, 200)\n"
				+ "    Node at 256, 0, 256: Empty\n"
				+ "    Node at 0, 256, 256: Empty\n"
				+ "    Node at 256, 256, 256: Empty\n"
				+ "  Node at 512, 0, 512: Empty\n"
				+ "  Node at 0, 512, 512: Empty\n"
				+ "  Node at 512, 512, 512: Empty\n", tree.dump());
	}

	public void testDuplicate() {
		tree.insert(test);
		tree.insert(test2);
		tree.insert(test3);
		tree.insert(test4);
		assertEquals("(1, 20)", tree.duplicate());
	}

	public void testRemove() {
		tree.insert(test);
		tree.insert(test2);
		tree.insert(test3);
		tree.insert(test4);
		tree.remove(10, 30);
		tree.remove(1, 20);
		tree.remove(200, 200);
//		assertEquals("", tree.duplicate());
	}
}
