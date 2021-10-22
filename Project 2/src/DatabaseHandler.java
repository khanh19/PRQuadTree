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

    public void insert(Point point) {
        if ((point.getX() < 1024 && point.getX() >= 0 && point.getY() < 1024 && point.getY() >= 0)) {
            String name = point.getName();
            KVPair<String, Point> po = new KVPair<String, Point>(name, point);
            skip.insert(po);
            quadTree.insert(point);
            System.out.println("Point inserted: " + point.toString());
        } else {
            System.out.println("Point REJECTED: " + point.toString());
        }
    }

    public String duplicate() {
        return "Duplicate Points:\n" + quadTree.duplicate();
    }

    public void search(String name) {
        ArrayList<Point> result = skip.search(name);
        if (result.size() == 0) {
            System.out.println("Point Not Found: " + name);
        } else {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) != null) {
                    System.out.println("Point Found: " + result.get(i).nameString() + "\n");
                }
            }
        }

    }

    public void removePoint(int x, int y) {
        Point remove = quadTree.remove(x, y);
        if (remove != null) {
            skip.remove(remove);
            System.out.println("Point removed: " + remove.nameString());
        } else {
            System.out.println("Point not found: (" + x + ", " + y + ")");
        }
    }

    public void removeName(String name) {
        Point point = skip.remove(name);
        if (point != null) {
            quadTree.remove(point);
            System.out.println("Point removed: " + point.nameString());
        } else {
            System.out.println("Point not removed: " + name);
        }
    }

    public void dump() {
        System.out.println("SKipList dump:");
        skip.dump();
        System.out.println("Quadtree dump:");
        System.out.print(quadTree.dump());
    }

}
