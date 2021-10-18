
public abstract class QuadInternal extends QuadNode{
    private QuadInternal NW;
    private QuadInternal NE;
    private QuadInternal SW;
    private QuadInternal SE;
    
    QuadInternal(){
        NW = null;
        NE = null;
        SW = null;
        SE = null;
    }
    
    
    
    public void setNW(QuadInternal value) {
        NW = value;
    }
    public QuadInternal getNW(){
        return NW;
    }
    public void setNE(QuadInternal value) {
        NE = value;
    }
    public QuadInternal getNE(){
        return NE;
    }
    
    public void setSW(QuadInternal value) {
        SW = value;
    }
    public QuadInternal getSW(){
        return SW;
    }
    public void setSE(QuadInternal value) {
        SE = value;
    }
    public QuadInternal getSE(){
        return SE;
    }


    
    
    
}
