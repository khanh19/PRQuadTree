import java.util.LinkedList;

public class QuadTree<E> {
    private QuadNode<E> root;
    private QuadEmpty<E> empty;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private int numOfElements;

    public QuadTree(){
        this.empty = new QuadEmpty<E>();
        this.root = empty;
        this.numOfElements = 0;
    }

    public QuadTree(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public void insert(Point element) {
        root = root.add(element, 0, 0, 1024);
        numOfElements++;
    }
    
    public int getSize() {
        return numOfElements;
    }

    public Point remove(int x, int y) {
        return null;
    }

    public Point search(Point item) {
        return null;
    }

    public String regionSearch(int x, int y, int w, int h) {
        // implement here
        return "";
    }

    public String duplicate()
    {
        if (root !=  null) {
            return root.duplicate();
        }
        return "";
    }

    public String dump() {
        if(root != null){
            return root.travesel(xMin,yMin,(xMax-xMin),0);
    	 } else {
    		 return "null";
    	 }
    }

}