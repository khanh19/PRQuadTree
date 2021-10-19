import java.util.LinkedList;

public interface QuadNode<E> {

    public boolean isLeaf();

    public QuadNode<E> getNodeByOrder(int order);

    public void setNodeByOrder(QuadNode<E> node, int order);

    public String duplicate();

    public void getAll(QuadNode<E> root, LinkedList<E> list);

    public int getHeight(int level);

    public E getValue();

    public void setValue(E item);
}
