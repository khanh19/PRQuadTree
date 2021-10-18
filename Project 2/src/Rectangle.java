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
public class Rectangle implements Comparable<Rectangle> {
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * default constructor
     */
    public Rectangle() {
        this.name = "";
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }


    /**
     * another constructor that contains all variables
     * 
     * @param name
     *            the name of rectangle
     * @param x
     *            the x dimesion
     * @param y
     *            the y dimenstion
     * @param width
     *            the width of rectangle
     * @param height
     *            the height of rectangle
     */
    public Rectangle(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    /**
     * method to get the rectangle's name
     * 
     * @return the rectangle name
     */

    public String getName() {
        return this.name;
    }


    /**
     * method to set the rectangle's name
     * 
     * @param name
     *            name of rectangle
     */

    public void setName(String name) {
        this.name = name;
    }


    /**
     * method to get the dimension
     * 
     * @return the position x
     */

    public int getX() {
        return this.x;
    }


    /**
     * method to set the rectangle's dimension X
     * 
     * @param x
     *            the x of dimension
     */

    public void setX(int x) {
        this.x = x;
    }


    /**
     * method to get the rectangle's y
     * 
     * @return the dimension y
     */

    public int getY() {
        return this.y;
    }


    /**
     * method to set the rectangle dimension
     * 
     * @param y
     *            the y of rectangle
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * method to get the rectangle's width
     * 
     * @return the width
     */

    public int getWidth() {
        return this.width;
    }


    /**
     * method to set the rectangle's width
     * 
     * @param wid
     *            the width of rectangle
     * @return true if width > 0, false if width < 0
     */
    public boolean setWidth(int wid) {
        if (wid > 0) {
            return true;
        }
        System.out.println("Height must be greater than 0");
        return false;
    }


    /**
     * method to get the rectangle's height
     * 
     * @return the height
     */
    public int getHeight() {
        return this.height;
    }


    /**
     * method to set the rectangle's height
     * 
     * @param hei
     *            the rectangle's height
     * @return true if height > 0, else false
     */
    public boolean setHeight(int hei) {
        if (hei > 0) {
            return true;
        }
        System.out.println("Height must be greater than 0");
        return false;
    }


    /**
     * compare method to compare two rectangles
     * 
     * @return the number
     */
    @Override
    public int compareTo(Rectangle rec) {
        if (rec == null) {
            throw new IllegalArgumentException(
                "Can not do comparision to null");
        }
        return this.name.compareTo(rec.getName());
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
        Rectangle rec = (Rectangle)other;
        return this.x == rec.getX() && this.y == rec.getY() && this.width == rec
            .getWidth() && this.height == rec.getHeight();
    }


    /**
     * method to show rectangle's detail
     * 
     * @return the rectangle's detail
     */
    public String toString() {
        return ("(" + this.name + ", " + (int)Math.round(this.x) + ", "
            + (int)Math.round(this.y) + ", " + (int)Math.round(this.width)
            + ", " + (int)Math.round(this.height) + ")");
    }

}
