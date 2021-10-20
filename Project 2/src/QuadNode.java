import java.util.LinkedList;

public interface QuadNode<E> {

    public boolean isLeaf();

    public QuadNode<E> getNodeByOrder(int order);

    public void setNodeByOrder(QuadNode<E> node, int order);

    public String duplicate(LinkedList<String> result);

    public void getAllNode(QuadNode<E> root, LinkedList<E> list);

    public int getHeight(int level);

    public E getValue();

    public void setValue(E item);

    public LinkedList<String> getContents(int x, int y, int range, LinkedList<String> list, int level, int[] numOfVisits);
    
    public QuadNode add(Point element, int x, int y, int split);
}
   
