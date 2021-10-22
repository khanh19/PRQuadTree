public class TestPoint extends student.TestCase {
	private Point test;
	private Point test1;
	private Object check;
	private Point test3;

	public TestPoint() {
		test = new Point("cuong", 10, 20);
		test3 = new Point("khanh", 5, 30);
		test1 = new Point("long", 20, 30);
	}

	public void testCompareTo() {
		assertEquals(3, test.compareTo(test1));
		assertEquals(2, test1.compareTo(test));
		assertEquals(1, test.compareTo(test));
		assertEquals(4, test.compareTo(test3));
		assertEquals(1, test3.compareTo(test));
		assertEquals("cuong", test.getName());
		Exception exception = null;
		try {
			test3.compareTo(null);
		} catch (IllegalArgumentException e) {
			exception = e;
		}
		assertNotNull(exception);

		test.setName("David");
		assertEquals("David", test.getName());
	}

	public void testGet() {
		assertEquals(10, test.getX());
		assertEquals(20, test.getY());

		test1.setX(30);
		test1.setY(40);

		assertEquals(30, test1.getX());
		assertEquals(40, test1.getY());
	}

	public void testEquals() {
		assertTrue(test.equals(test));
		assertFalse(test.equals(null));
		assertFalse(test.equals(check));
	}

	public void testToString() {
		assertEquals("(10, 20)", test.toString());
		assertEquals("(cuong, 10, 20)", test.nameString());
	}
}
