
public class TestZone extends student.TestCase{
	private Zone test;
	private Zone test1;
	private Zone test2;
	private Zone test3;
	private Point Test;
	private Point Test2;
	private Point Test3;
	private Point test4;
	private Point test5;
	private Point test6;
	public void setUp() {
		test = new Zone(5, 10, 15, 20);
		test1 = new Zone(10, 15, 0, 20);
		test2 = new Zone(15, 20, 35, 0);
		test3 = new Zone(20, 15, 0, 0);
		Test = new Point("cuong", 1, 20);
		Test2 = new Point("Khanh", 10, 30);
		Test3 = new Point("Long", 1, 20);
		test4 = new Point("test", 200, 200);
		test5 = new Point("Giang", 300, 300);
		test6 = new Point("test6", 6, 11);
	}
	public void testGet() {
		assertEquals(5, test.getX());
		assertEquals(10, test.getY());
		assertEquals(15, test.getW());
		assertEquals(20, test.getH());
	}
	public void testSet() {
		test.setX(10);
		test.setY(15);
		test.setW(20);
		test.setH(25);
		assertEquals(10, test.getX());
		assertEquals(15, test.getY());
		assertEquals(20, test.getW());
		assertEquals(25, test.getH());
		assertFalse(test.isEmpty());
		assertTrue(test1.isEmpty());
		assertTrue(test2.isEmpty());
		assertTrue(test3.isEmpty());
		assertEquals("( 10, 15, 20, 25 )", test.toString());
	}
	public void testInside() {
		assertFalse(test.wrap(test1));
		assertFalse(test.wrap(test2));
		assertTrue(test.wrap(test3));
		
		assertFalse(test.isInside(Test));
		assertFalse(test.isInside(Test2));
		assertFalse(test.isInside(Test3));
		assertFalse(test.isInside(test4));
		assertFalse(test.isInside(test5));
		assertTrue(test.isInside(test6));
	}
	public void testIntesect() {
		assertEquals("( 10, 15, 0, 15 )", test.intersects(test1).toString());
		assertEquals("( 15, 20, 5, 0 )", test.intersects(test2).toString());
		assertEquals("( 0, 0, 0, 0 )", test2.intersects(test3).toString());
		
		assertEquals("( 5, 20, 7, 10 )", test.dividedById(1).toString());
		assertEquals("( 12, 20, 7, 10 )", test.dividedById(2).toString());
		assertEquals("( 5, 10, 7, 10 )", test.dividedById(3).toString());
		assertEquals("( 12, 10, 7, 10 )", test.dividedById(4).toString());
		assertEquals("( 5, 10, 7, 10 )", test.dividedById(5).toString());

		

		
	}

}
