
public abstract class QuadLeaf<E> extends QuadNode<E>{
    private E element;
    
    QuadLeaf(E theElement){
        element = theElement;
    }
    
    public E getElement() {
        return element;
    }
    
    public void setElement(E value) {
        element = value;
    }
}
