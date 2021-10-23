import java.util.LinkedList;

public class QuadLeaf<E> implements QuadNode<E> {
	private E element;
	public LinkedList<Point> list;

	public QuadLeaf() {
		list = new LinkedList<Point>();
	}

	public QuadLeaf(LinkedList<Point> newList) {
		list = newList;
	}

	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public QuadNode<E> getNodeByOrder(int order) {
		return null;
	}

	@Override
	public void setNodeByOrder(QuadNode<E> node, int order) {

	}

	@Override
	public String duplicate() {
		String str = "";
		for (int i = 0; i < this.list.size(); i++) {
			for (int j = i + 1; j < this.list.size(); j++) {
				Point temp1 = this.list.get(i);
				Point temp2 = this.list.get(j);
				// must be equals
				if (temp1.equals(temp2)) {
					str += temp1.toString();
				}
			}
		}
		return str;
	}

	@Override
	public void getAllNode(QuadNode<E> root, LinkedList<E> lister) {
		for (E item : lister) {
			list.add((Point) item);
		}
	}
	/**
	@Override
	public int getHeight(int level) {
		return level + 1;
	}
	**/

	@Override
	public LinkedList<Point> getValue() {
		return list;
	}

	@Override
	public void setValue(E item) {
		this.element = item;

	}

	@Override
	public String traversel(int x, int y, int range, int level) {
		String str = "";
		for (int i = 0; i < level; i++) {
			str += "  ";
		}
		str += "Node at " + Integer.toString(x) + ", " + Integer.toString(y) + ", " + Integer.toString(range) + ":\n";
		for (int j = list.size() - 1; j >= 0; j--) {
			for (int i = 0; i < level + 1; i++)
				str += "  ";
			str += list.get(j).nameString() + "\n";
		}
		QuadTree.setCount();
		return str;
	}

	@Override
	public QuadNode<E> add(Point element, int x, int y, int split) {
		if (list.size() == 0) {
			list.add(element);
			return this;
		} else if (list.size() < 3) {
			list.add(element);
			return this;
		} else if (list.size() >= 3) {
			int check = 0;
			for (int i = 0; i < this.list.size(); i++) {
				if (list.get(i).compareTo(element) == 0) {
					check++;
				}
			}
			if (check == list.size()) {
				list.add(element);
				return this;
			}
		}

		QuadNode newInternal = new QuadInternal();
		for (int i = 0; i < list.size(); i++) {
			newInternal = newInternal.add(list.get(i), x, y, split);
		}
		newInternal = newInternal.add(element, x, y, split);
		return newInternal;

	}

	@Override
	public QuadNode<E> remove(int x, int y, int currentX, int currentY, int check) {
		for (int i = 0; i < list.size(); i++) {
			if (x == list.get(i).getX() && y == list.get(i).getY()) {
				QuadTree.setPoint(list.get(i));
				list.remove(i);
				break;
			}
		}
		if (list.size() == 0) {

			return new QuadEmpty<E>();
		}
		return this;
	}

	@Override
	public QuadNode<E> remove(Point element, int currentX, int currentY, int check) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == element) {
				QuadTree.setPoint(list.get(i));
				list.remove(i);
				break;
			}
		}
		if (list.size() == 0) {

			return new QuadEmpty<E>();
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedList<Point> regionSearch(int xMin, int yMin, int size, int x, int y, int w, int h, LinkedList<Point> lister) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getX() >= x && list.get(i).getX() < x + w && list.get(i).getY() >= y
					&& list.get(i).getY() < y + h) {
				lister.add(list.get(i));
			}
		}
		QuadTree.setRegion();
		return lister;

	}

}
