import java.util.LinkedList;

public class QuadLeaf<E> implements QuadNode<E> {
    private E element;
    private LinkedList<Point> list;

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
    public String duplicate(LinkedList<String> result) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.list.size(); i++) {
            for (int j = i + 1; j < this.list.size(); j++) {
                Point temp1 = this.list.get(i);
                Point temp2 = this.list.get(j);
                if (temp1.compareTo(temp2) == 0) {
                    str.append("( " + temp1.getX() + ", " + temp1.getY() + ")");
                    result.add(str.toString());
                }
            }
        }
        return result.toString();
    }


    @Override
    public void getAllNode(QuadNode<E> root, LinkedList<E> list) {

    }


    @Override
    public int getHeight(int level) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public E getValue() {
        // TODO Auto-generated method stub
        return element;
    }


    @Override
    public void setValue(E item) {
        this.element = item;

    }

    @Override
    public QuadNode<E> add(Point element, int x, int y, int split) {
        if(list.size() == 0) {
            list.add(element);
            return this;
        }
        else if (list.size() < 3) {
            list.add(element);
            return this;
        }
        else if (list.size() >= 3) {
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


    public LinkedList<String> getContents(
        int currentX,
        int currentY,
        int split,
        LinkedList<String> result,
        int numOfIndents,
        int[] numOfVisits) {
        String indents = "";
        String temp = "";
        for (int i = 0; i < numOfIndents; i++)
            indents = indents + "  ";
        temp = temp + indents;
        temp = temp + "Node at " + ((Integer)currentX).toString() + ", "
            + ((Integer)currentY).toString() + ", " + ((Integer)split)
                .toString() + ":";
        result.add(temp);
        temp = "";
        for (int i = 0; i < this.list.size(); i++) {

            temp = indents + "(" + this.list.get(i).toString() + ")";
            result.add(temp);
        }
        numOfVisits[0]++;
        return result;
    }

}
