import java.util.LinkedList;

public class QuadEmpty implements QuadNode {
    private static QuadNode instance = new QuadEmpty();

    public static QuadNode getQuadEmpty(){
        return instance;
    }

    public QuadNode add(Point element, int currentX, int currentY, int split) {

        QuadLeaf temp = new QuadLeaf();
        temp.add(element, currentX, currentY, split);
        return temp;
    }


    public LinkedList<Point> find(
        int x,
        int y,
        int currentX,
        int currentY,
        int split,
        LinkedList<Point> result) {
        return result;
    }


    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public QuadNode getNodeByOrder(int order) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void setNodeByOrder(QuadNode node, int order) {
        // TODO Auto-generated method stub

    }


    @Override
    public String duplicate() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void getAllNode(QuadNode root, LinkedList list) {
        // TODO Auto-generated method stub

    }


    @Override
    public int getHeight(int level) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public void setValue(Object item) {
        // TODO Auto-generated method stub

    }


    @Override
    public String traversel(int x, int y, int range, int level) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public LinkedList getContents(
        int i,
        int j,
        int k,
        LinkedList list,
        int l,
        int[] numOfVisits) {
        String temp = "";
        for (int a = 0; a < l; a++) {
            temp = temp + "  ";
        }
        temp = temp + "Node at " + ((Integer)i).toString() + ", " + ((Integer)j)
            .toString() + ", " + ((Integer)k).toString() + ": Empty";
        list.add(temp);
        numOfVisits[0]++;
        return list;
    }

    @Override
    public Object getValue() {
        // TODO Auto-generated method stub
        return null;
    }

}
