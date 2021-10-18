
public class QuadNode<E> {
    private QuadNode<E> NW;
    private QuadNode<E> NE;
    private QuadNode<E> SW;
    private QuadNode<E> SE;
    private E element;
    
    QuadNode(E theElement){
        element = theElement;
        NW = null;
        NE = null;
        SW = null;
        SE = null;
    }
    
    public E getElement() {
        return element;
    }
    
    public void setElement(E value) {
        element = value;
    }
    
    public void setNW(QuadNode<E> value) {
        NW = value;
    }
    public QuadNode<E> getNW(){
        return NW;
    }
    public void setNE(QuadNode<E> value) {
        NE = value;
    }
    public QuadNode<E> getNE(){
        return NE;
    }
    
    public void setSW(QuadNode<E> value) {
        SW = value;
    }
    public QuadNode<E> getSW(){
        return SW;
    }
    public void setSE(QuadNode<E> value) {
        SE = value;
    }
    public QuadNode<E> getSE(){
        return SE;
    }
    
    
    
}
