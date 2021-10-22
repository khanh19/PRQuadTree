
public class TestQuadTree extends student.TestCase {
	private QuadTree tree;
	private Point test;
	private Point test2;
	private Point test3;
	private Point test4;
	private Point test5;
	private Point test6;
	private Point giangTest;
	private Point giangTest1;
	private Point giangTest2;
	private Point giangTest3;

	public void setUp() {
		test = new Point("cuong", 1, 20);
		test2 = new Point("Khanh", 10, 30);
		test3 = new Point("Long", 1, 20);
		test4 = new Point("test", 200, 200);
		test5 = new Point("Giang", 50, 80);
		test6 = new Point("test6", 1, 200);
		tree = new QuadTree(0, 1024, 0, 1024);
		giangTest = new Point("a", 1, 1);
		giangTest1 = new Point("b1", 551, 1);
		giangTest2 = new Point("a1", 2, 1);
		giangTest3 = new Point("b2", 553, 1);
	}

	public void testInsert() {
		tree.insert(test);
		tree.insert(test2);
		tree.insert(test3);
		tree.insert(test4);
		assertEquals(4, tree.getSize());
		assertEquals("Node at 0, 0, 1024: Internal\n" + "  Node at 0, 0, 512: Internal\n"
				+ "    Node at 0, 0, 256: Internal\n" + "      Node at 0, 0, 128:\n" + "        (Long, 1, 20)\n"
				+ "        (Khanh, 10, 30)\n" + "        (cuong, 1, 20)\n" + "      Node at 128, 0, 128: Empty\n"
				+ "      Node at 0, 128, 128: Empty\n" + "      Node at 128, 128, 128:\n" + "        (test, 200, 200)\n"
				+ "    Node at 256, 0, 256: Empty\n" + "    Node at 0, 256, 256: Empty\n"
				+ "    Node at 256, 256, 256: Empty\n" + "  Node at 512, 0, 512: Empty\n"
				+ "  Node at 0, 512, 512: Empty\n" + "  Node at 512, 512, 512: Empty\n"
						+ "13 quadtree nodes printed\n", tree.dump());
	}

	public void testDuplicate() {
		tree.insert(test);
		tree.insert(test2);
		tree.insert(test3);
		tree.insert(test4);
		assertEquals("(1, 20)", tree.duplicate());
		tree.remove(1, 20);
		assertEquals("", tree.duplicate());
	}

	public void testRemove() {
		tree.insert(test);
		tree.insert(test2);
		tree.insert(test3);
		tree.insert(test4);
		System.out.println(tree.regionSearch(0, 0, 25, 25));
		System.out.print(tree.dump());
		System.out.println("--------------------------");
		tree.insert(test6);
		tree.insert(test5);
		tree.remove(200, 200);
		
		tree.remove(test5);
		tree.remove(1, 200);
		assertEquals(3, tree.getSize());
		assertEquals("Node at 0, 0, 1024:\n"
				+ "  (Long, 1, 20)\n"
				+ "  (Khanh, 10, 30)\n"
				+ "  (cuong, 1, 20)\n"
				+ "1 quadtree nodes printed\n", tree.dump());

	}
	public void testRegionSearch() {
		tree.insert(giangTest);
		tree.insert(giangTest2);
		tree.insert(giangTest3);
		tree.insert(giangTest1);
		System.out.println(tree.dump());
		System.out.println("---------------------");
		System.out.print(tree.regionSearch(0, 0, 768, 768));
		System.out.print(tree.regionSearch(752, 752, 224, 224));
		System.out.print(tree.regionSearch(0, 0, -5, -5));
		assertEquals(5, tree.getCount());
	}
}
