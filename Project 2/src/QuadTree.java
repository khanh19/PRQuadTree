import java.util.LinkedList;

public class QuadTree<E> {
	private QuadNode<E> root;
	private QuadEmpty<E> empty;
	private int xMin;
	private int xMax;
	private int yMin;
	private int yMax;
	private int numOfElements;
	private static int a = 0;
	private static Point remove;
	private static int count = 0;

	public static void setCount() {
		a++;

	}
	public static void setRegion() {
		count++;
	}
	public static int getRegion() {
		return count;
	}
	public static void resetRegion() {
		count = 0;
	}
	public static int getCount() {
		return a;

	}
	public static void setPoint(Point e) {
		remove = e;
	}
	public static Point getPoint() {
		return remove;
	}
	public static void resetCount() {
		a = 0;
	}

	public QuadTree(int xMin, int xMax, int yMin, int yMax) {
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
		this.empty = new QuadEmpty<E>();
		this.root = empty;
		this.numOfElements = 0;
		remove = new Point();
	}

	public void insert(Point element) {
		root = root.add(element, 0, 0, 1024);
		numOfElements++;
	}

	public int getSize() {
		return numOfElements;
	}

	public Point remove(Point element) {
		root = root.remove(element, 0, 0, 1024);
		numOfElements--;
		return null;

	}

	public Point remove(int x, int y) {
		root = root.remove(x, y, 0, 0, 1024);
		numOfElements--;
		return QuadTree.getPoint();
	}

	

	 public String regionSearch(int x, int y, int w, int h) {
		 	QuadTree.resetRegion();
	    	String str = "";
	        LinkedList<Point> outList = new LinkedList<Point>();
	        outList = root.regionSearch(0, 0, 1024, x, y, w, h, outList);
	        
	        if (outList != null) {
	        	for (Point ele: outList) {
	        		str += "Point Found: " + ele.nameString() + "\n";
	        	}
	        }
	        str += QuadTree.getRegion() + " QuadTree Nodes Visited\n";
	        return str;
	    }
	public String duplicate() {
		if (root != null) {
			return root.duplicate();
		}
		return "";
	}

	public String dump() {
		QuadTree.resetCount();;
		String str = "";
		if (root != null) {
			str = str + root.traversel(xMin, yMin, (xMax - xMin), 0);
			str = str + QuadTree.getCount() + " quadtree nodes printed\n";
		} else {
			str = str + "null";
		}
		return str;
	}

}
