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
        if (root instanceof QuadEmpty) {
            return;
        }

        if (NW instanceof QuadEmpty) {
            NW.getAllNode(NW, list);
        }
        if (NE instanceof QuadEmpty) {
            NE.getAllNode(NE, list);
        }
        if (SW instanceof QuadEmpty) {
            SW.getAllNode(SW, list);
        }
        if (SE instanceof QuadEmpty) {
            SE.getAllNode(SE, list);
        }

    }

    @Override
    public int getHeight(int level) {
        int x, y, z, t;
        if (!(NW instanceof QuadEmpty)) {
            x = NW.getHeight(level + 1);
        } else {
            x = NW.getHeight(level);
        }

        if (!(NE instanceof QuadEmpty)) {
            y = NE.getHeight(level + 1);
        } else {
            y = NE.getHeight(level);
        }

        if (!(SW instanceof QuadEmpty)) {
            z = SW.getHeight(level + 1);
        } else {
            z = SW.getHeight(level);
        }

        if (!(SE instanceof QuadEmpty)) {
            t = SE.getHeight(level + 1);
        } else {
            t = SE.getHeight(level);
        }

        return Math.max(Math.max(x, y), Math.max(z, t));
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
            result += NW.traversel(x, y, range / 2, level + 1);
        } else {
            int tempx = x;
            int tempy = y;
            result += NW.traversel(tempx, tempy, range, level);
        }

        if (!(NE instanceof QuadEmpty)) {
            result += NE.traversel(x, y, range / 2, level + 1);
        } else {
            int tempx = x + range / 2;
            int tempy = y;
            result += NE.traversel(tempx, tempy, range, level);
        }

        if (!(SW instanceof QuadEmpty)) {
            result += SW.traversel(x, y, range / 2, level + 1);
        } else {
            int tempx = x;
            int tempy = y + range / 2;
            result += SW.traversel(tempx, tempy, range, level);
        }

        if (!(SE instanceof QuadEmpty)) {
            result += SE.traversel(x, y, range / 2, level + 1);
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
        if (x < i + check && y < j + check) {
            NW = NW.remove(x, y, i, j, split);
        } else if (x < i + check && y >= j + check) {
            SW = SW.remove(x, y, i, j + split, split);
        } else if (x >= i + check && y < j + check) {
            NE = NE.remove(x, y, i + split, j, split);
        } else {
            SE = SE.remove(x, y, i + split, j + split, split);
        }
        return this;
    }

}
