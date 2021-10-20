import java.util.LinkedList;

public class QuadInternal<E> implements QuadNode<E> {
    private QuadNode<E> NW;
    private QuadNode<E> NE;
    private QuadNode<E> SW;
    private QuadNode<E> SE;

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
        QuadNode<E> node = null;
        switch (order) {
            case 1:
                node = this.NW;
            case 2:
                node = this.NE;
            case 3:
                node = this.SW;
            case 4:
                node = this.SE;
            default:
                System.out.println("Order not in range 1-4");
                node = null;
        }
        return node;
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
    public void getAllNode(QuadNode<E> root, LinkedList<E> list) {
        if (root != null) {
            if (NW != null) {
                NW.getAllNode(NW, list);
            }
            if (NE != null) {
                NE.getAllNode(NE, list);
            }
            if (SW != null) {
                SW.getAllNode(SW, list);
            }
            if (SE != null) {
                SE.getAllNode(SE, list);
            }
        }

    }

    @Override
    public int getHeight(int level) {
        int x, y, z, t;
        if (!(NW instanceof QuadEmpty)) {
            x = NW.getHeight(level + 1);
        }
        else{
            x = NW.getHeight(level);
        }

        if (!(NE instanceof QuadEmpty)) {
            y = NE.getHeight(level + 1);
        }
        else{
            y = NE.getHeight(level);
        }

        if (!(SW instanceof QuadEmpty)) {
            z = SW.getHeight(level + 1);
        }
        else{
            z = SW.getHeight(level);
        }

        if (!(SE instanceof QuadEmpty)) {
            t = SE.getHeight(level + 1);
        }
        else{
            t = SE.getHeight(level);
        }

        return return Math.max(Math.max(x, y),Math.max(z, t));
    }

    @Override
    public E getValue() {
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
        result += "Node at " + x.toString() + ", " + y.toString() + ", " + scale.toString() + ": Internal\n";
        if (!(NW instanceof QuadEmpty)) {
            result += NW.travesal(x, y, range / 2, level + 1);
        } else {
            result += NW.travesal(x, y, range, level);
        }

        if (!(NE instanceof QuadEmpty)) {
            result += NE.travesal(x, y, range / 2, level + 1);
        } else {
            result += NE.travesal(x, y, range, level);
        }

        if (!(SW instanceof QuadEmpty)) {
            result += SW.travesal(x, y, range / 2, level + 1);
        } else {
            result += SW.travesal(x, y, range, level);
        }

        if (!(SE instanceof QuadEmpty)) {
            result += SE.travesal(x, y, range / 2, level + 1);
        } else {
            result += SE.travesal(x, y, range, level);
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

    public LinkedList<String> getContents(int currentX, int currentY, int bound, LinkedList<String> list,
            int numOfIndents, int[] numOfVisits) {
        int split = bound / 2;
        String temp = "";
        for (int i = 0; i < numOfIndents; i++)
            temp = temp + "  ";
        temp = temp + "Node at " + ((Integer) currentX).toString() + ", " + ((Integer) currentY).toString() + ", "
                + ((Integer) bound).toString() + ": Internal";
        list.add(temp);
        list = NW.getContents(currentX, currentY, split, list, numOfIndents + 1, numOfVisits);
        list = NE.getContents(currentX + split, currentY, split, list, numOfIndents + 1, numOfVisits);
        list = SW.getContents(currentX, currentY + split, split, list, numOfIndents + 1, numOfVisits);
        list = SE.getContents(currentX + split, currentY + split, split, list, numOfIndents + 1, numOfVisits);
        numOfVisits[0]++;
        return list;
    }

}
