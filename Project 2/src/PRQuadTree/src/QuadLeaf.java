import java.util.LinkedList;

public class QuadLeaf<E> implements QuadNode<E> {

    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public QuadNode<E> getNodeByOrder(int order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setNodeByOrder(QuadNode<E> node, int order) {
        // TODO Auto-generated method stub

    }

    @Override
    public String duplicate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void getAll(QuadNode<E> root, LinkedList<E> list) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getHeight(int level) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public E getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setValue(E item) {
        // TODO Auto-generated method stub

    }

}