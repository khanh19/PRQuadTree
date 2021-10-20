import java.util.LinkedList;

public class QuadEmpty<E> implements QuadNode<E> {
    // private static QuadNode instance = new QuadEmpty();

    // public static QuadNode getQuadEmpty(){
    // return instance;
    // }

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
        str += "Node at " + Integer.toString(x) + ", " + Integer.toString(x) + ", " + Integer.toString(nRange)
                + ": Empty\n";
        return str;
    }

    @Override
    public LinkedList getContents(int i, int j, int k, LinkedList list, int l, int[] numOfVisits) {
        String temp = "";
        for (int a = 0; a < l; a++) {
            temp = temp + "  ";
        }
        temp = temp + "Node at " + ((Integer) i).toString() + ", " + ((Integer) j).toString() + ", "
                + ((Integer) k).toString() + ": Empty";
        list.add(temp);
        numOfVisits[0]++;
        return list;
    }

    @Override
    public Object getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public QuadNode<E> remove(Point element, int i, int j, int check) {
        return this;
    }

}
