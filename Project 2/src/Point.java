
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * class of rectangle
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 */
public class Point implements Comparable<Point> {
    private int x;
    private int y;
    private String name;
    /**
     * default constructor
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    
    public Point(String name,int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    /**
     * another constructor that contains all variables

     * @param x
     *            the x dimesion
     * @param y
     *            the y dimenstion
     */
    public Point(int xMin, int xMax, int yMin, int yMax) {
        this.x = (xMin + xMax) / 2;
        this.y = (yMin + yMax) / 2;
    }

    @Override
    public int compareTo(Point poi) {
        if (poi == null) {
            throw new IllegalArgumentException(
                "Can not do comparision to null");
        }
        if(this.x <= poi.x && this.y>=poi.y){
			return 1;
		} else if(this.x>poi.x&&this.y>poi.y){
			return 2;
		} else if(this.x<poi.x && this.y<poi.y){
			return 3;
		} else {
			return 4;
		} 
    }
        

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }


    /**
     * equals method
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Point point = (Point)other;
        return this.x == point.getX() && this.y == point.getY();
    }

    public String nameString() {
    	return ("(" + this.name + (int)Math.round(this.x) + ", "
                + (int)Math.round(this.y) + ")");
    }
    /**
     * method to show rectangle's detail
     * 
     * @return the rectangle's detail
     */
    public String toString() {
        return ("(" + (int)Math.round(this.x) + ", "
            + (int)Math.round(this.y) + ")");
    }

}
