
public class QuadTree<E extends Comparable<? super E>> {
    private QuadNode<E> root;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    public QuadTree(int xMin, int xMax, int yMin, int yMax) {
        this.root = null;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public void insert(E item) {
        // implement here
    }

    public E remove(E item) {
        // implement here
        return item;
    }

    public E search(E item) {
        // implement here
        return item;
    }

    public String regionSearch(int x, int y, int w, int h) {
        // implement here
        return "";
    }

    public String dump() {
        // implement here
        return "";
    }

    public QuadNode<E> getHead() {
        return root;
    }
}
