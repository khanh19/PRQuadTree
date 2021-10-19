import java.util.LinkedList;

public class QuadInternal<E> implements QuadNode<E> {
    private QuadNode<E> NW;
    private QuadNode<E> NE;
    private QuadNode<E> SW;
    private QuadNode<E> SE;

    private QuadInternal() {
        this.NW = null;
        this.NE = null;
        this.SW = null;
        this.SE = null;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public QuadNode<E> getNodeByOrder(int order) {
        QuadNode<E> node = null;
         switch(order){
             case 1:
                 node = this.NW;
             case 2:
                node = this.NE;
             case 3:
              node 
             case 4:

             default:
         }
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
    public void getAll(QuadNode root, LinkedList list) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

    }

}
