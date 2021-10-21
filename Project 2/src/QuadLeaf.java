import java.util.LinkedList;

public class QuadLeaf<E> implements QuadNode<E> {
    private E element;
    public LinkedList<Point> list;

    public QuadLeaf() {
        list = new LinkedList<Point>();
    }

    public QuadLeaf(LinkedList<Point> newList, E newElement) {
        list = newList;
        element = newElement;
    }

    public boolean isEmpty() {
        if (element == null) {
            return true;
        }
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
    public void getAllNode(QuadNode<E> root, LinkedList<E> list) {
        for (E item : list) {
            list.add(item);
        }
    }

    @Override
    public int getHeight(int level) {
        return level + 1;
    }

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

        for (Point element : list) {
            for (int i = 0; i < level + 1; i++)
                str += "  ";
            str += element.nameString() + "\n";
        }
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

    public LinkedList<String> getContents(int currentX, int currentY, int split, LinkedList<String> result,
            int numOfIndents, int[] numOfVisits) {
        String indents = "";
        String temp = "";
        for (int i = 0; i < numOfIndents; i++)
            indents = indents + "  ";
        temp = temp + indents;
        temp = temp + "Node at " + ((Integer) currentX).toString() + ", " + ((Integer) currentY).toString() + ", "
                + ((Integer) split).toString() + ":";
        result.add(temp);
        temp = "";
        for (int i = 0; i < this.list.size(); i++) {

            temp = indents + "(" + this.list.get(i).toString() + ")";
            result.add(temp);
        }
        numOfVisits[0]++;
        return result;
    }

    @Override
    public QuadNode<E> remove(int x, int y, int currentX, int currentY, int check) {
        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i).getX() && y == list.get(i).getY()) {
                list.remove(i);
                break;
            }
        }
        if (list.size() == 0) {

            return new QuadEmpty<E>();
        }
        return this;
    }

}
