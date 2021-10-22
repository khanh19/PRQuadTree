import java.util.LinkedList;

public class QuadEmpty<E> implements QuadNode<E> {
	public QuadEmpty() {

	}

	public QuadNode<E> add(Point element, int currentX, int currentY, int split) {

		QuadLeaf<E> temp = new QuadLeaf<E>();
		temp.add(element, currentX, currentY, split);
		return temp;
	}

	public LinkedList<Point> find(int x, int y, int currentX, int currentY, int split, LinkedList<Point> result) {
		return result;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public QuadNode<E> getNodeByOrder(int order) {
		return null;
	}

	@Override
	public void setNodeByOrder(QuadNode<E> node, int order) {
		return;

	}

	@Override
	public String duplicate() {
		return "";
	}

	@Override
	public void getAllNode(QuadNode<E> root, LinkedList<E> list) {
		//Do nothing
	}

	@Override
	public int getHeight(int level) {
		return level;
	}

	@Override
	public void setValue(Object item) {
		return;

	}

	@Override
	public String traversel(int x, int y, int range, int level) {
		String str = "";
		for (int i = 0; i < level + 1; i++) {
			str += "  ";
		}
		int nRange = range / 2;
		str += "Node at " + ((Integer) x).toString() + ", " + ((Integer) y).toString() + ", "
				+ ((Integer) nRange).toString() + ": Empty\n";
		return str;
	}

	@Override
	public LinkedList<Point> getValue() {
		return null;
	}

	@Override
	public QuadNode<E> remove(int x, int y, int i, int j, int check) {
		return this;
	}

	@Override
	public QuadNode<E> remove(Point element, int i, int j, int check) {
		return this;
	}

	@Override
	public LinkedList<Point> regionSearch(int xMin, int yMin, int size, int x, int y, int w, int h, LinkedList<Point> lister) {
		return lister;
		
	}

}
