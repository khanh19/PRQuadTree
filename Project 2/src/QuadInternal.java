import java.util.LinkedList;

public class QuadInternal<E> implements QuadNode<E> {
	private QuadNode<E> NW;
	private QuadNode<E> NE;
	private QuadNode<E> SW;
	private QuadNode<E> SE;
	private E element;
	private LinkedList<Point> results;

	public QuadInternal() {
		this.NW = new QuadEmpty<E>();
		this.NE = new QuadEmpty<E>();
		this.SW = new QuadEmpty<E>();
		this.SE = new QuadEmpty<E>();
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public QuadNode<E> getNodeByOrder(int order) {
		switch (order) {
		case 1:
			return this.NW;
		case 2:
			return this.NE;
		case 3:
			return this.SW;
		case 4:
			return this.SE;
		default:
			System.out.println("The input direction is not right(1-4)");
			return null;
		}
	}

	@Override
	public void setNodeByOrder(QuadNode<E> root, int order) {
		switch (order) {
		case 1:
			NW = root;
		case 2:
			NE = root;
		case 3:
			SW = root;
		case 4:
			SE = root;
		default:
			System.out.println("Order not in range 1-4");
		}
	}

	@Override
	public String duplicate() {
		String str = "";
		if (!(NW instanceof QuadEmpty)) {
			str += NW.duplicate();
		}
		if (!(NE instanceof QuadEmpty)) {
			str += NE.duplicate();
		}
		if (!(SW instanceof QuadEmpty)) {
			str += SW.duplicate();
		}
		if (!(SE instanceof QuadEmpty)) {
			str += SE.duplicate();
		}
		return str;
	}

	@Override
	public void getAllNode(QuadNode<E> root, LinkedList<E> lister) {
		if (root instanceof QuadEmpty) {
			return;
		}

		if (NW instanceof QuadEmpty) {
			NW.getAllNode(NW, lister);
		}
		if (NE instanceof QuadEmpty) {
			NE.getAllNode(NE, lister);
		}
		if (SW instanceof QuadEmpty) {
			SW.getAllNode(SW, lister);
		}
		if (SE instanceof QuadEmpty) {
			SE.getAllNode(SE, lister);
		}

	}


	@Override
	public LinkedList<Point> getValue() {
		return null;
	}

	@Override
	public void setValue(Object item) {
		return;
	}

	@Override
	public String traversel(int x, int y, int range, int level) {
		String result = "";
		for (int i = 0; i < level; i++) {
			result += "  ";
		}
		result += "Node at " + Integer.toString(x) + ", " + Integer.toString(y) + ", " + Integer.toString(range)
				+ ": Internal\n";
		if (!(NW instanceof QuadEmpty)) {
			int tempx = x;
			int tempy = y;
			result += NW.traversel(tempx, tempy, range / 2, level + 1);
		} else {
			int tempx = x;
			int tempy = y;
			result += NW.traversel(tempx, tempy, range, level);
		}

		if (!(NE instanceof QuadEmpty)) {
			int tempx = x + range / 2;
			int tempy = y;
			result += NE.traversel(tempx, tempy, range / 2, level + 1);
		} else {
			int tempx = x + range / 2;
			int tempy = y;
			result += NE.traversel(tempx, tempy, range, level);
		}

		if (!(SW instanceof QuadEmpty)) {
			int tempx = x;
			int tempy = y + range / 2;
			result += SW.traversel(tempx, tempy, range / 2, level + 1);
		} else {
			int tempx = x;
			int tempy = y + range / 2;
			result += SW.traversel(tempx, tempy, range, level);
		}

		if (!(SE instanceof QuadEmpty)) {
			int tempx = x + range / 2;
			int tempy = y + range / 2;
			result += SE.traversel(tempx, tempy, range / 2, level + 1);
		} else {
			int tempx = x + range / 2;
			int tempy = y + range / 2;
			result += SE.traversel(tempx, tempy, range, level);
		}
		return result;
	}

	@Override
	public QuadNode<E> add(Point element, int x, int y, int split) {
		int check = split / 2;
		if (element.getX() < x + check && element.getY() < y + check) {
			NW = NW.add(element, x, y, check);
			return this;
		} else if (element.getX() < x + check && element.getY() >= y + check) {
			SW = SW.add(element, x, y + check, check);
			return this;
		} else if (element.getX() >= x + check && element.getX() < y + check) {
			NE = NE.add(element, x + check, y, check);
			return this;
		} else {
			SE = SE.add(element, x + check, y + check, check);
			return this;
		}
	}

	@Override
	public QuadNode<E> remove(int x, int y, int i, int j, int check) {
		int split = check / 2;
		if (x < i + split && y < j + split) {
			NW = NW.remove(x, y, i, j, split);
		} else if (x < i + split && y >= j + split) {
			SW = SW.remove(x, y, i, j + split, split);
		} else if (x >= i + split && y < j + split) {
			NE = NE.remove(x, y, i + split, j, split);
		} else {
			SE = SE.remove(x, y, i + split, j + split, split);
		}

		return merge();
	}

	@Override
	public QuadNode<E> remove(Point element, int i, int j, int check) {
		int split = check / 2;
		if (element.getX() < i + split && element.getY() < j + split) {
			NW = NW.remove(element, i, j, split);
		} else if (element.getX() < i + split && element.getY() >= j + split) {
			SW = SW.remove(element, i, j + split, split);
		} else if (element.getX() >= i + split && element.getY() < j + split) {
			NE = NE.remove(element, i + split, j, split);
		} else {
			SE = SE.remove(element, i + split, j + split, split);
		}

		return merge();
	}

	private QuadNode merge() {
		if (NW.isLeaf() && NE == new QuadEmpty<E>() && SW == new QuadEmpty<E>() && SE == new QuadEmpty<E>()) {
			return NW;
		} else if (NE.isLeaf() && NW == new QuadEmpty<E>() && SW == new QuadEmpty<E>() && SE == new QuadEmpty<E>()) {
			return NE;
		} else if (SW.isLeaf() && NE == new QuadEmpty<E>() && NW == new QuadEmpty<E>() && SE == new QuadEmpty<E>()) {
			return SW;
		} else if (SE.isLeaf() && NE == new QuadEmpty<E>() && NW == new QuadEmpty<E>() && SW == new QuadEmpty<E>()) {
			return SE;
		} else {
			LinkedList<Point> string = new LinkedList<Point>();
			if (NW.isLeaf()) {
				for (int i = 0; i < ((QuadLeaf) NW).list.size(); i++) {
					string.add((Point) ((QuadLeaf) NW).list.get(i));
				}
			}
			if (NE.isLeaf()) {
				for (int i = 0; i < ((QuadLeaf) NE).list.size(); i++) {
					string.add((Point) ((QuadLeaf) NE).list.get(i));
				}
			}
			if (SW.isLeaf()) {
				for (int i = 0; i < ((QuadLeaf) SW).list.size(); i++) {
					string.add((Point) ((QuadLeaf) SW).list.get(i));
				}
			}
			if (SE.isLeaf()) {
				for (int i = 0; i < ((QuadLeaf) SE).list.size(); i++) {
					string.add((Point) ((QuadLeaf) SE).list.get(i));
				}
			}
			if (string.size() == 3) {
				return new QuadLeaf(string);
			}
			return this;
		}
	}

	@Override
	public LinkedList<Point> regionSearch(int xMin, int yMin, int size, int x, int y, int w, int h, LinkedList<Point> lister) {
		int xR = xMin + size / 2;
		int yR = yMin + size / 2;
		int yB = y + h - 1;
		int xB = x + w - 1;
		LinkedList<Point> result = lister;
		if (xR > x && yR > y) {
			result = NW.regionSearch(xMin, yMin, size / 2, x, y, w, h, result);
		}

		if (xR <= xB && yR > y) {
			result = NE.regionSearch(xMin, yMin, size / 2, x, y, w, h, result);
		}

		if (xR > x && yR <= yB) {
			result = SW.regionSearch(xMin, yMin, size / 2, x, y, w, h, result);
		}

		if (xB >= xR && yB >= yR) {
			result = SE.regionSearch(xMin, yMin, size / 2, x, y, w, h, result);
		}
		return result;
	}

}
