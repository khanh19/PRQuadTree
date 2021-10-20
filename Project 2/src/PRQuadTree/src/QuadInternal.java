import java.util.LinkedList;

public class QuadInternal<E> implements QuadNode<E> {
    private QuadNode<E> NW;
    private QuadNode<E> NE;
    private QuadNode<E> SW;
    private QuadNode<E> SE;

    public QuadInternal() {
        this.NW = QuadEmpty.getQuadEmpty();
        this.NE = QuadEmpty.getQuadEmpty();
        this.SW = QuadEmpty.getQuadEmpty();
        this.SE = QuadEmpty.getQuadEmpty();
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
        StringBuilder str = new StringBuilder();
        if (NW != null) {
            str.append(NW.duplicate());
        }
        if (NE != null) {
            str.append(NE.duplicate());
        }
        if (SW != null) {
            str.append(SW.duplicate());
        }
        if (SE != null) {
            str.append(SE.duplicate());
        }
        return str.toString();
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
        // TODO Auto-generated method stub
        return 0;
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
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public QuadNode<E> add(Point element, int x, int y, int split) {
        int check = split / 2;
        if (element.getX() < x + check && element.getY() < y + check) {
            NW = NW.add(element, x, y, check);
            return this;
        }
        else if (element.getX() < x + check && element.getY() >= y + check) {
            SW = SW.add(element, x, y + check, check);
            return this;
        }
        else if (element.getX() >= x + check && element.getX() < y + check) {
            NE = NE.add(element, x + check, y, check);
            return this;
        }
        else {
            SE = SE.add(element, x + check, y + check, check);
            return this;
        }
    }


    @Override
    
    public LinkedList<String> getContents(int currentX, int currentY,
            int bound, LinkedList<String> list, int numOfIndents, 
            int[] numOfVisits) {
        int split = bound / 2;
        String temp = "";
        for (int i = 0; i < numOfIndents; i++)
            temp = temp + "  ";
        temp = temp + "Node at " + ((Integer) currentX).toString() + 
                ", " + ((Integer) currentY).toString() + ", "
                + ((Integer) bound).toString() + ": Internal";
        list.add(temp);
        list = NW.getContents(currentX , currentY , split, list,
                numOfIndents + 1, numOfVisits);
        list = NE.getContents(currentX + split, currentY , split, list,
                numOfIndents + 1, numOfVisits);
        list = SW.getContents(currentX , currentY + split, split, list, 
                numOfIndents + 1, numOfVisits); 
        list = SE.getContents(currentX + split, currentY + split, split,
                list, numOfIndents + 1, numOfVisits);
        numOfVisits[0]++;
        return list;
    }

}
