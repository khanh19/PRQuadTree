import java.util.LinkedList;

public class QuadEmpty<E> implements QuadNode<E> {

	public QuadEmpty() {

	}

	public QuadNode add(Point element, int currentX, int currentY, int split) {

		QuadLeaf temp = new QuadLeaf();
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
	public QuadNode getNodeByOrder(int order) {
		return null;
	}

	@Override
	public void setNodeByOrder(QuadNode node, int order) {
		// TODO Auto-generated method stub

	}

	@Override
	public String duplicate() {
		return "";
	}

	@Override
	public void getAllNode(QuadNode root, LinkedList list) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHeight(int level) {
		return level;
	}

	@Override
	public void setValue(Object item) {
		// TODO Auto-generated method stub

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
	public E getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadNode<E> remove(int x, int y, int i, int j, int check) {
		return this;
	}

}
