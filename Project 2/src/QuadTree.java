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

	public static void setCount() {
		a++;

	}

	public static int getCount() {
		return a;

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
		return null;
	}

	public String regionSearch(int x, int y, int w, int h) {
		Zone given = new Zone(x, y, w, h);
		Zone curr = new Zone(xMin, yMin, xMax - xMin, yMax - yMin);
		return regionSearchHelper(root, given, curr);
	}

	private String regionSearchHelper(QuadNode<E> root, Zone given, Zone current) {
		String str = "";
		LinkedList<E> nodes = new LinkedList<E>();
		if (root instanceof QuadEmpty) {
			return "";
		}

		if (!(given.wrap(current))) {
			if (root.isLeaf()) {
				for (Point ele : root.getValue()) {
					if (given.isInside(ele)) {
						str += ele.nameString() + "\n";
					}
				}
			} else {
				Zone tempGiven, tempCurr = null;
				for (int i = 1; i <= 4; i++) {
					tempCurr = current.dividedById(i);
					tempGiven = given.intersects(tempCurr);
					if (!(root.getNodeByOrder(i) == null || tempGiven.isEmpty())) {
						str += regionSearchHelper(root.getNodeByOrder(i), tempGiven, tempCurr);
					}
				}
			}
		} else {
			root.getAllNode(root, nodes);
			for (E node : nodes) {
				str += ((Point) node).nameString() + "\n";
			}

		}
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
