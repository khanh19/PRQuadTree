import java.util.LinkedList;

public class QuadTree {
    private QuadNode root;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private int numOfElements;

    public QuadTree(int xMin, int xMax, int yMin, int yMax) {
        this.root = QuadEmpty.getQuadEmpty();
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        numOfElements = 0;
    }

    public void insert(Point element) {
        root = root.add(element, 0, 0, 1024);
        numOfElements++;
    }
    public String findDuplicate() {
    	LinkedList<String> find = new LinkedList<String>();
    	return root.duplicate(find);
    	
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

    public LinkedList<String> dump() {
        
        int[] numOfVisits = {0};
        LinkedList<String> list = new LinkedList<String>();
        if (numOfElements == 0) {
            String temp = "Node at 0, 0, 1024: Empty";
            list.add(temp);
            temp = "1 quadtree nodes printed";
            list.add(temp);
        } 
        else {
            root.getContents(0, 0, 1024, list, 0, numOfVisits);
            list.add(numOfVisits[0] + 
                    " quadtree nodes printed");
        }
       
        return list;
    }

}
