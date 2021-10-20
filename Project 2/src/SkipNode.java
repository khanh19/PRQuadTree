
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * 
 * /**
 * SkipNode class
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 * @param <E>
 *            the element
 */
public class SkipNode<E> {
    /**
     * SkipNode next
     */
    private SkipNode<E>[] elevate;
    private E value;

    /**
     * default constructor
     * 
     * @param value
     *            the value of SkipNode
     * @param level
     *            the level of SkipNode
     */
    @SuppressWarnings("unchecked")
    public SkipNode(E value, int level) {
        this.value = value;
        elevate = new SkipNode[level + 1];
    }


    /**
     * Skip node
     * 
     * @return Skip Node
     */
    public SkipNode<E>[] getElevate() {
        return this.elevate;
    }


    /**
     * method to get the value SkipNode
     * 
     * @return the value
     */
    public E value() {
        return this.value;
    }

}
