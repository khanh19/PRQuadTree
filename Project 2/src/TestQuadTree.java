
public class TestQuadTree extends student.TestCase{
    private QuadTree tree;
    private QuadNode<Point> root;
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
        assertEquals("[Node at 0, 0, 1024: Internal,   Node at 0, 0, 512: Internal,     Node at 0, 0, 256: Internal,       Node at 0, 0, 128:,       ((1, 20)),       ((10, 30)),       ((1, 20)),       Node at 128, 0, 128: Empty,       Node at 0, 128, 128: Empty,       Node at 128, 128, 128:,       ((200, 200)),     Node at 256, 0, 256: Empty,     Node at 0, 256, 256: Empty,     Node at 256, 256, 256: Empty,   Node at 512, 0, 512: Empty,   Node at 0, 512, 512: Empty,   Node at 512, 512, 512: Empty, 13 quadtree nodes printed]", tree.dump().toString());
    }
    public void testDuplicate() {
        tree.insert(test);
        tree.insert(test2);
        tree.insert(test3);
        tree.insert(test4);
    	System.out.print(tree.findDuplicate());
    }

}
