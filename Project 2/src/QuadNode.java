
public abstract class QuadNode<E> {
    
    abstract E getElement();
    
    abstract void setElement();
    
    abstract void setNW(QuadInternal value);
    
    abstract void setNE(QuadInternal value);
    
    abstract void setSW(QuadInternal value);
    
    abstract void setSE(QuadInternal value);
    
    abstract QuadInternal getNW();
    
    abstract QuadInternal getNE();
    
    abstract QuadInternal getSW();
    
    abstract QuadInternal getSE();
    
}
