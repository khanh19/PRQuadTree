import java.util.LinkedList;

public interface QuadNode<E> {

    public boolean isLeaf();

    public QuadNode<E> getNodeByOrder(int order);

    public void setNodeByOrder(QuadNode<E> node, int order);

    public String duplicate();

    public void getAllNode(QuadNode<E> root, LinkedList<E> list);

    public LinkedList<Point> getValue();

    public void setValue(E item);

    public String traversel(int x, int y, int range, int level);

    public QuadNode add(Point element, int x, int y, int split);

    public QuadNode<E> remove(int x, int y, int i, int j, int check);
    
    public QuadNode<E> remove(Point element, int i, int j, int check);
}
