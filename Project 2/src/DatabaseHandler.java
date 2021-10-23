import java.util.ArrayList;

public class DatabaseHandler {
    private SkipList<String, Point> skip;
    private QuadTree<Point> quadTree;

    public DatabaseHandler(int xMin, int xMax, int yMin, int yMax) {
        this.skip = new SkipList<String, Point>();
        this.quadTree = new QuadTree<>(xMin, xMax, yMin, yMax);
    }

    public SkipList<String, Point> getSkip() {
        return this.skip;
    }

    public void setSkip(SkipList<String, Point> skip) {
        this.skip = skip;
    }

    public QuadTree<Point> getQuadTree() {
        return this.quadTree;
    }

    public void setQuadTree(QuadTree<Point> quadTree) {
        this.quadTree = quadTree;
    }

    public String insert(Point point) {
    	String str = "";
        if ((point.getX() < 1024 && point.getX() >= 0 && point.getY() < 1024 && point.getY() >= 0)) {
            String name = point.getName();
            KVPair<String, Point> po = new KVPair<String, Point>(name, point);
            skip.insert(po);
            quadTree.insert(point);
            str = str + "Point inserted: " + point.nameString() + "\n";
        } else {
            str = str + "Point rejected: " + point.nameString() + "\n";
        }
        return str;
    }

    public String duplicate() {
    	if(quadTree.duplicate() == "") {
    		return "Duplicate points:" + "\n";
    	}
        return "Duplicate points:\n" + quadTree.duplicate() + "\n";
    }

  
    public String search(String name) {
    	String str = "";
        ArrayList<Point> result = skip.search(name);
        if (result == null) {
            str = str + "Point not found: " + name + "\n";
        } else {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) != null) {
                   str = str + "Found " + result.get(i).nameString() + "\n";
                }
            }
        }
        return str;

    }

    public String removePoint(int x, int y) {
    	String str = "";
        Point remove = quadTree.remove(x, y);
        if (remove != null) {
            quadTree.remove(remove);
            skip.remove(remove);
            str = str + "Point " + remove.nameString() + " Removed" + "\n";
        } else {
           str = str + "Point not found: (" + x + ", " + y + ")" + "\n";
        }
        return str;
    }

    public String removeName(String name) {
    	String str = "";
        Point point = skip.remove(name);
        if (point != null) {
            quadTree.remove(point);
            str = str + "Point " + point.nameString() + " Removed" + "\n";
        } else {
            str = str + "Point not removed: " + name + "\n";
        }
        return str;
    }

    public String dump() {
    	String str = "";
        str = str + skip.dump();
        str = str + "QuadTree dump:" + "\n";
        str = str + quadTree.dump();
        return str;
    }
    
    public String regionSearch(int x, int y, int w, int h) {
    	String str = "";
    	str += "Points intersecting region: (" + x + ", " + y + ", " + w + ", " + h  + ")\n";
    	str += quadTree.regionSearch(x, y, w, h);
    	return str;
    }

}
