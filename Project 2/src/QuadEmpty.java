import java.util.LinkedList;

public class QuadEmpty<E> implements QuadNode<E> {

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
		QuadTree.setCount();
		return str;
	}

	@Override
	public LinkedList<Point> getValue() {
		return null;
	}

	@Override
	public QuadNode<E> remove(int x, int y, int i, int j, int check) {
		return null;
	}

	@Override
	public QuadNode<E> remove(Point element, int i, int j, int check) {
		return null;
	}

	@Override
	public void setValue(E item) {
		// TODO Auto-generated method stub
		
	}

}
