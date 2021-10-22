import java.util.LinkedList;

public class QuadTree<E> {
    private QuadNode<E> root;
    private QuadEmpty<E> empty;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private int numOfElements;

    public QuadTree(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.empty = new QuadEmpty<E>();
        this.root = empty;
        this.numOfElements = 0;
    }

    public void insert(Point element) {
        root = root.add(element, 0, 0, 1024);
        numOfElements++;
    }

    public int getSize() {
        return numOfElements;
    }
    public Point remove(Point element) {
    	root = root.remove(element, 0, 0, 1024);
    	numOfElements--;
    	return null;
    	
    }
    public Point remove(int x, int y) {
        root = root.remove(x, y, 0, 0, 1024);
        numOfElements--;
        return null;
    }

    public String regionSearch(int x, int y, int w, int h) {
    	String str = "";
        LinkedList<Point> outList = new LinkedList<Point>();
        outList = root.regionSearch(0, 0, 1024, x, y, w, h, outList);
        
        if (outList != null) {
        	for (Point ele: outList) {
        		str += "Point Found: " + ele.nameString() + "\n";
        	}
        }
        return str;
    }

//    private String regionSearchHelper(QuadNode<E> root, Zone given, Zone current) {
////        String str = "";
////        LinkedList<E> nodes = new LinkedList<E>();
////        if (root == null) {
////            return "";
////        }
////
////        if (!(given.wrap(current))) {
////            if (root.isLeaf()) {
////            	System.out.println("huhuhhuhuhuhuhuh");
////                for (Point ele : root.getValue()) {
////                    if (given.isInside(ele)) {
////                        str += ele.nameString() + "\n";
////                    }
////                }
////            } else {
////            	System.out.println("hahahahhahah");
////                Zone tempGiven, tempCurr = null;
////                for (int i = 1; i < 5; i++) {
////                    tempCurr = current.dividedById(i);
////                    tempGiven = given.intersects(tempCurr);
////                    System.out.println(tempGiven.isEmpty());
////           
////                    if (!(root.getNodeByOrder(i) == null || tempGiven.isEmpty())) {
////                        str += regionSearchHelper(root.getNodeByOrder(i), tempGiven, tempCurr);
////                    }
////                }
////            }
////        } else {
////        	System.out.println("lalalalalalal");
////            root.getAllNode(root, nodes);
////            for (E node : nodes) {
////                str += ((Point) node).nameString() + "\n";
////            }
////
////        }
////        return str;
//    	
//    }

    public String duplicate() {
        if (root != null) {
            return root.duplicate();
        }
        return "";
    }

    public String dump() {
        if (root != null) {
            return root.traversel(xMin, yMin, (xMax - xMin), 0);
        } else {
            return "null";
        }
    }

}
